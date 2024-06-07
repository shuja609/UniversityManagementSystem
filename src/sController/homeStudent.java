package sController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
public class homeStudent {
String username;

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
    void courseReg(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sView/courseRegistration.fxml"));

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setScene(new Scene(root));

    }

    @FXML
    void st_marks(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sView/Student_Marks_C.fxml"));

        Node node = (Node) event.getSource();

//        Stage stage = (Stage) node.getScene().getWindow();
//
//        stage.setScene(new Scene(root));
        if (node != null) {
            Scene scene = node.getScene();
            if (scene != null) {
                Stage stage = (Stage) scene.getWindow();
                if (stage != null) {
                    stage.setScene(new Scene(root));
                } else {
                    System.err.println("Stage is null");
                }
            } else {
                System.err.println("Scene is null");
            }
        } else {
            System.err.println("Node is null");
        }

    }

    @FXML
    void transcript(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sView/transcript.fxml"));

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
