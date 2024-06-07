package fController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utilities.sqliteConnection;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ResourceBundle;
// Faculty Attendence
public class attendenceFaculty implements Initializable {


    @FXML
    private Label courseLabel;
    @FXML
    private TableView<modelAttdFaculty> table;
    @FXML
    private TableColumn<modelAttdFaculty,String> col_stdId;
    @FXML
    private TableColumn<modelAttdFaculty,String> col_cId;
    @FXML
    private TextField textLecture;
    @FXML
    private ComboBox<String> duration;
    @FXML
    private ComboBox<String> presence;

    @FXML
    private DatePicker textDate;

    public Connection con;
    ObservableList<modelAttdFaculty> obList = FXCollections.observableArrayList();

    public String std_id,course_id,cour_id;

    ObservableList<String> durationList = FXCollections.observableArrayList("1:30","2:00","3:00");
    ObservableList<String> presenceList = FXCollections.observableArrayList("P","L","A");
    public void setCourseId(String courseId) {
        this.cour_id = courseId;
        courseLabel.setText(courseId); 
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting combobox values
        duration.setItems(durationList);
        presence.setItems(presenceList);


        try {
            con  = sqliteConnection.dbConnector();
//            ResultSet rs = con.createStatement().executeQuery("SELECT usr.id ,cID FROM users as usr, registration as c WHERE c.sID = usr.id AND cID = (SELECT id from courses WHERE code = '"+cour_id+"');");
            ResultSet rs = con.createStatement().executeQuery(
            		" SELECT usr.id, res.sID, c2.code AS courseID"
            		+ " FROM users AS usr"
            		+ " JOIN registration AS res ON res.sID = usr.id"
            		+ " JOIN courses AS c2 ON res.cID = c2.id;"
            		+ " "  
            );
            while (rs.next()){
                obList.add(new modelAttdFaculty(rs.getString("id"),rs.getString("courseID")));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        col_stdId.setCellValueFactory(new PropertyValueFactory<>("std_id"));
        col_cId.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        table.setItems(obList);

        table.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() >= 1) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    modelAttdFaculty selectedStudent = table.getSelectionModel().getSelectedItem();
                    std_id = selectedStudent.getStd_id();
                    course_id = selectedStudent.getCourse_id();
                    JOptionPane.showMessageDialog(null,std_id+"\n"+cour_id);
                }
            }
        });

    }
    @FXML
    void saveAttendence(){
    	try {
    	 if (std_id == null || cour_id == null) {
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Invalid Selection");
             alert.setHeaderText(null);
             alert.setContentText("Please select a student and a course before saving attendance.");
             alert.showAndWait();
             return;
         }
        DatePicker dob= new DatePicker();
        String dura, lecNo, pres;
        LocalDate dobe = textDate.getValue();

        dura=  duration.getValue();
        lecNo = textLecture.getText();
        pres = presence.getValue();
//
        if (dobe == null || dura == null || lecNo == null || lecNo.isEmpty() || pres == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Incomplete Data");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all the required fields.");
            alert.showAndWait();
            return;
        }
        String query = "INSERT INTO attendence VALUES('"+std_id+"','"+cour_id+"',"+lecNo+",'"+dobe+"','"+dura+"','"+pres+"');";

        try {
//        	System.out.println("Value are, "+std_id);
            con  = sqliteConnection.dbConnector();
            con.createStatement().executeUpdate(query);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Attendance updated successfully!");
            alert.showAndWait();
        }catch (SQLIntegrityConstraintViolationException e) {
                // Handle specific duplicate key error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Duplicate Entry");
                alert.setHeaderText(null);
                alert.setContentText("This attendance record already exists in the database.");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to update attendance due to a database error. Please try again./n" + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An unexpected error occurred. Please try again./n" + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }
    @FXML
    void FacultyDashboard(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fView/homeFaculty.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    void logout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/mainP/login.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    void marks(MouseEvent event) throws  IOException{
        String courseId = cour_id;
        final FXMLLoader fxmlLoader;
        if(courseId == null) {
            JOptionPane.showMessageDialog(null,"Please select your course id..:/)");
        }
        else{
            fxmlLoader = new FXMLLoader(getClass().getResource("/fView/attendenceFaculty.fxml"));
            fxmlLoader.getNamespace().put("courseText", courseId);
            Parent root = fxmlLoader.load();
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
    }

}
