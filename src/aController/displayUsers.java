package aController;

import javafx.collections.FXCollections;


import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mainP.Course;
import mainP.user;
import utilities.sqliteConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
// display users
public class displayUsers implements Initializable {

    @FXML
    private TableView<user> tableView;
    @FXML
    private TableColumn<user,Integer> idColumn;
    @FXML
    private TableColumn<user,String> FNameColumn;
    @FXML
    private TableColumn<user,String> LNameColumn;
    
    
    @FXML
    private TableColumn<user,String> typeColumn;
    @FXML
    private TableColumn<user, String> dobColumn;



    @FXML
    public void loadData() {

        idColumn.setCellValueFactory(new PropertyValueFactory<user,Integer>("id"));
        FNameColumn.setCellValueFactory(new PropertyValueFactory<user,String>("fname"));
        LNameColumn.setCellValueFactory(new PropertyValueFactory<user,String>("lname"));
     
        typeColumn.setCellValueFactory(new PropertyValueFactory<user,String>("typee"));
        dobColumn.setCellValueFactory(new PropertyValueFactory<user,String>("dob"));

        tableView.setItems(getUsers());
    }

    public ObservableList<user> getUsers(){
        ObservableList<user> user= FXCollections.observableArrayList();
        try {
            Connection connection = sqliteConnection.dbConnector();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                user.add(new user(resultSet.getInt("id"), resultSet.getString("FName"), resultSet.getString("LName"),  resultSet.getString("type"), resultSet.getString("dob")));
            }


        } catch (SQLException e) {
            System.err.println("Cannot Connect to Database");
        }



        return user;
    }

    @FXML
    public void rmData() throws SQLException {
        user selectedItem = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(selectedItem);


        Connection connection= sqliteConnection.dbConnector();
        Statement statement = connection.createStatement();

        int status = statement.executeUpdate("DELETE FROM users WHERE id= '"+selectedItem.getId()+"'");

        if (status==1) {
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Remove Course");
            alert.setHeaderText(null);
            alert.setContentText("User "+selectedItem.getFname()+" "+selectedItem.getLname()+" have been removed Successfuly!");
            alert.showAndWait();
        }
    }


    @FXML
    void setting(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/aView/setting.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }



    @FXML
    void duser(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/aView/displayCourses.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void dcourse(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/aView/displayCourses.fxml"));
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
    void homei(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/aView/homeView.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void Courses(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/aView/courses.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void dash(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/aView/homeAdmin.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void users(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/aView/users.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    
    @FXML
    public void updateData() {
        user selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select a user to update.");
            alert.showAndWait();
            return;
        }

        Dialog<user> dialog = new Dialog<>();
        dialog.setTitle("Update User");

        ButtonType updateButtonType = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField firstNameField = new TextField();
        firstNameField.setText(selectedItem.getFname());
        TextField lastNameField = new TextField();
        lastNameField.setText(selectedItem.getLname());
        TextField typeField = new TextField();
        typeField.setText(selectedItem.getTypee());
        LocalDate dobValue = null;
        try {
            dobValue = LocalDate.parse(selectedItem.getDob());
        } catch (Exception e) {
            // Handle parsing exception by setting dobValue to null or a default value
        	dobValue = LocalDate.now();
        }
        DatePicker dobPicker = new DatePicker(dobValue);
        
        grid.add(new Label("First Name:"), 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(new Label("Type:"), 0, 2);
        grid.add(typeField, 1, 2);
        grid.add(new Label("Date of Birth:"), 0, 3);
        grid.add(dobPicker, 1, 3);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == updateButtonType) {
                return new user(selectedItem.getId(), firstNameField.getText(), lastNameField.getText(), typeField.getText(), dobPicker.getValue().toString());
            }
            return null;
        });

        Optional<user> result = dialog.showAndWait();

        result.ifPresent(updatedUser -> {
            try {
                Connection connection = sqliteConnection.dbConnector();
                Statement statement = connection.createStatement();

                String query = String.format("UPDATE users SET FName='%s', LName='%s', type='%s', dob='%s' WHERE id=%d",
                        updatedUser.getFname(), updatedUser.getLname(), updatedUser.getTypee(), updatedUser.getDob(), updatedUser.getId());

                int status = statement.executeUpdate(query);

                if (status == 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Update User");
                    alert.setHeaderText(null);
                    alert.setContentText("User updated successfully!");
                    alert.showAndWait();
                    loadData(); // Refresh the table data
                }
            } catch (SQLException e) {
                //System.err.println("Error updating user: " + e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setHeaderText(null);
                alert.setContentText("Error updating user. Please try again./n" + e.getMessage());
                alert.showAndWait();
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
    }
}
