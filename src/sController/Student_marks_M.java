package sController;
import utilities.sqliteConnection;
import javax.swing.*;

import javafx.scene.control.Alert;

import java.sql.*;
import mainP.Student;
import mainP.Login;
public class Student_marks_M {

    // parameters
    public String query;
    public String query1;
    private Statement st ;
    private Connection cn;
    private ResultSet rs;
    public String id;
    public String student_id;
    private final sqliteConnection db = new sqliteConnection();
    // methods
    public Student_marks_M(){

        student_id = Student.getSid();
    }

    
    
    public ResultSet calculate_obtn_marks(String course, String input)
    {

        //JOptionPane.showMessageDialog(null, "ID is :- " + id);
        cn = db.dbConnector();
        if(input == "Quiz_Marks")
        {
            query = "select marks from quiz where std_id = '"+student_id+"' and course_id = '"+course+"';";
//            System.out.println("Hello........."+student_id+ " " +course+ " ");
        }
        if(input == "Assignments_Marks")
        {
            query = "select marks from assignment where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "sessional")
        {
            query = "select marks from sessional where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "final")
        {
            query = "select marks from final where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "project")
        {
            query = "select marks from project where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }

        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An unexpected error occurred. Please try again./n" + e.getMessage());
        }

        return rs;

    }
    public ResultSet calculate_total_marks(String course, String input)
    {
        String id = "student_id";
        cn = db.dbConnector();
        if(input == "Quiz_Marks")
        {
            query = "select Total_marks from quiz where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "Assignments_Marks")
        {
            query = "select Total_marks from assignment where std_id like "+student_id+" and course_id like '%"+course+"%';";
        }
        if(input == "sessional")
        {
            query = "select Total_marks from sessional where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "final")
        {
            query = "select Total_marks from final where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "project")
        {
            query = "select Total_marks from project where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }

        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
        	 Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setTitle("Error");
             alert.setHeaderText(null);
             alert.setContentText("An unexpected error occurred. Please try again./n" + e.getMessage());
        }

        return rs;

    }

    public ResultSet calculate_nos(String course, String input)
    {
    	try {
        cn = db.dbConnector();
        if(input == "Quiz_Marks")
        {
            query = "select id from quiz where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "Assignments_Marks")
        {
            query = "select id from assignment where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "sessional")
        {
            query = "select id from sessional where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "final")
        {
            query = "select id from final where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }
        if(input == "project")
        {
            query = "select id from project where std_id like '"+student_id+"' and course_id like '%"+course+"%';";
        }

        
            st = cn.createStatement();
            rs = st.executeQuery(query);

          } catch (SQLException e) {
            showAlert("Database Error", "An error occurred while accessing the database.", e.getMessage());
           // e.printStackTrace();
        } catch (IllegalArgumentException e) {
            showAlert("Input Error", "Invalid input type provided.", e.getMessage());
           // e.printStackTrace();
        } catch (Exception e) {
            showAlert("Unknown Error", "An unexpected error occurred.", e.getMessage());
           // e.printStackTrace();
        }

        return rs;

    }

    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    // work on obtained grand total marks

    public ResultSet Q_OB_marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(marks) from quiz where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet A_OB_marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(marks) from assignment where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet S_OB_marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(marks) from sessional where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet F_OB_Marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(marks) from final where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet P_OB_Marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(marks) from project where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    // working on total marks
    public ResultSet P_Total_Marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(Total_marks) from project where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet S_Total_Marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(Total_marks) from sessional where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet Q_Total_Marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(Total_marks) from quiz where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet A_Total_Marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(Total_marks) from assignment where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet F_Total_Marks(String course_id)
    {
        cn = db.dbConnector();
        String query = "select sum(Total_marks) from final where std_id like '"+student_id+"' and course_id like '%"+course_id+"%'";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //...................................................................................................................//////////////////

    // working on quizes
    public ResultSet working_Min_Quiz(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select min(marks) from quiz where course_id like '%"+course+"%' and Qno like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet working_Max_Quiz(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select max(marks) from quiz where course_id like '%"+course+"%' and Qno like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingAvgQuiz(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select avg(marks) from quiz where course_id like '%"+course+"%' and Qno like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingStdQuiz(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select std(marks) from quiz where course_id like '%"+course+"%' and Qno like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // working on assignments
    public ResultSet workingStdAss(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select std(marks) from assignment where course_id like '%"+course+"%' and Assignment_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingMinAss(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select min(marks) from assignment where course_id like '%"+course+"%' and Assignment_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingMaxAss(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select max(marks) from assignment where course_id like '%"+course+"%' and Assignment_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingAvgAss(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select avg(marks) from assignment where course_id like '%"+course+"%' and Assignment_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // working on sessionals
    public ResultSet workingAvgSessional(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select avg(marks) from sessional where course_id like '%"+course+"%' and sessional_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingMinSessional(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select min(marks) from sessional where course_id like '%"+course+"%' and sessional_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingMaxSessional(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select max(marks) from sessional where course_id like '%"+course+"%' and sessional_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingStdSessional(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select std(marks) from sessional where course_id like '%"+course+"%' and sessional_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // working on finals
    public ResultSet workingAvgFinal(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select avg(marks) from final where course_id like '%"+course+"%' and final_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingMinFinal(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select min(marks) from final where course_id like '%"+course+"%' and final_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingMaxFinal(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select max(marks) from final where course_id like '%"+course+"%' and final_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingStdFinal(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select std(marks) from final where course_id like '%"+course+"%' and final_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // working on projects
    public ResultSet workingAvgProjects(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select avg(marks) from project where course_id like '%"+course+"%' and project_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingMinProjects(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select min(marks) from project where course_id like '%"+course+"%' and project_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingMaxProjects(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select max(marks) from project where course_id like '%"+course+"%' and project_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet workingStdProjects(String course, String no)
    {
        cn = db.dbConnector();
        String query = "select std(marks) from project where course_id like '%"+course+"%' and project_no like "+no+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //////////////////////////////////.................

    public ResultSet registeredCourses()
    {
        cn = db.dbConnector();

        query1 = "select code from courses as c, registration as re where cID = c.id AND sID = "+student_id+";";
        try {
            st = cn.createStatement();
            rs = st.executeQuery(query1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Not working");
            e.printStackTrace();
        }
        return rs;
    }

}
