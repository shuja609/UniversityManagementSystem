package sController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import mainP.Course;
import mainP.Student;
import utilities.sqliteConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.List;

public class courseRegistration implements Initializable {

	@FXML
	private TableView<Course> tableView;

	@FXML
	private TableColumn<Course, Integer> idColumn;

	@FXML
	private TableColumn<Course, String> CNameColumn;

	@FXML
	private TableColumn<Course, String> preReqColumn;

	@FXML
	private TableColumn<Course, Integer> CHrsColumn;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		idColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("id"));
		CNameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("cName"));
		preReqColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("PreReq"));
		CHrsColumn.setCellValueFactory(new PropertyValueFactory<Course, Integer>("cHrs"));

		tableView.setItems(getCourses());
	}

	public ObservableList<Course> getCourses() {
		ObservableList<Course> Course = FXCollections.observableArrayList();
		try {
			Connection connection = sqliteConnection.dbConnector();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from courses");
			while (resultSet.next()) {
				Course.add(new Course(resultSet.getInt("id"), resultSet.getString("cName"), resultSet.getString("code"),
						resultSet.getInt("cHrs"), resultSet.getString("aTeacher"), resultSet.getString("preReq"),
						resultSet.getString("type"), resultSet.getInt("semester")));
			}

		} catch (SQLException e) {
			System.err.println("Cannot Connect to Database");
		}

		return Course;
	}

	@FXML
	public void registerCourse() throws SQLException {

		try {
			Course selectedItem = tableView.getSelectionModel().getSelectedItem();
			if (selectedItem == null) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("No Selection");
				alert.setHeaderText(null);
				alert.setContentText("Please select a course to register.");
				alert.showAndWait();
				return;
			}
			ArrayList<Integer> totalCredit = new ArrayList<>();
			Integer sums = 0;

			Connection connection = sqliteConnection.dbConnector();
			Statement statement = connection.createStatement();

			ResultSet resultSets = statement.executeQuery(
					"SELECT * FROM registration INNER JOIN courses ON courses.id = registration.cID where sID="
							+ Student.id + "");
			while (resultSets.next()) {
				totalCredit.add(resultSets.getInt("cHrs"));
				sums += resultSets.getInt("cHrs");
			}
			if (sums <= 18) {
				Alert alerts = new Alert(Alert.AlertType.INFORMATION);
				alerts.setTitle("Register Course");
				alerts.setHeaderText(null);
				alerts.setContentText("You have registered " + sums + " Credit Hours");
				alerts.showAndWait();
				ResultSet resultSet = statement.executeQuery(
						"select * from registration where cID = " + selectedItem.id + " and sID = " + Student.id + ";");

				if (resultSet.next()) {

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Register Course");
					alert.setHeaderText(null);
					alert.setContentText("You have Registered this Subject already!");
					alert.showAndWait();
				} else {
					int status = statement.executeUpdate(
							"INSERT INTO registration (cID,sID) VALUES (" + selectedItem.id + "," + Student.id + ")");

					if (status == 1) {
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("Register Course");
						alert.setHeaderText(null);
						alert.setContentText("Course " + selectedItem.CName + " have been Registered Successfuly!");
						alert.showAndWait();
					}
				}
			} else {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Credit Hours Exceeded");
				alert.setHeaderText(null);
				alert.setContentText("You cannot register more than 18 credit hours. Current total: " + sums);
				alert.showAndWait();
			}
		} catch (SQLException e) {
			//System.err.println("Database error: " + e.getMessage());
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Database Error");
			alert.setHeaderText(null);
			alert.setContentText("An error occurred while connecting to the database. Please try again./n" + e.getMessage());
			alert.showAndWait();
		} catch (Exception e) {
			//System.err.println("Error: " + e.getMessage());
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("An unexpected error occurred. Please try again./n" + e.getMessage());
			alert.showAndWait();
		}

	}

	// Event Handlers
	@FXML
	void logout(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/mainP/login.fxml"));
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setScene(new Scene(root));

	}

	@FXML
	void homei(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/sView/homeview.fxml"));
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setScene(new Scene(root));

	}

	@FXML
	void attendance(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/sView/Attendance_atd.fxml"));

		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();

		stage.setScene(new Scene(root));

	}

	@FXML
	void transcript(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/sView/transcript.fxml"));

		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();

		stage.setScene(new Scene(root));

	}

	@FXML
	void dash(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/sView/homeStudent.fxml"));

		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();

		stage.setScene(new Scene(root));

	}

	@FXML
	void st_marks(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/sView/Student_Marks_C.fxml"));

		Node node = (Node) event.getSource();

		Stage stage = (Stage) node.getScene().getWindow();

		stage.setScene(new Scene(root));

	}

	@FXML
	void studyPlan(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/sView/semester1.fxml"));
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setScene(new Scene(root));

	}

	@FXML
	void feeDe(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/sView/feeDetails.fxml"));
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setScene(new Scene(root));

	}
}
