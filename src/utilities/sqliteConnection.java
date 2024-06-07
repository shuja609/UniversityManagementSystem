package utilities;

import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class sqliteConnection {
	//Connection conn=null;
	public static Connection dbConnector() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String urllink = "jdbc:mysql://localhost:3306/sda_project";
			String myname = "root";
			String password = "sql@123";
			Connection conn=DriverManager.getConnection(urllink, myname, password);
			
			//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/academiastream", "root", "pass123");
			//Class.forName("org.sqlite.JDBC");
//			JOptionPane.showMessageDialog(null, "Successfully Connected!!");
			//Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\databases\\mydatabase.sqlite");
			return conn;
		}
		catch(Exception exc) 
		{
//			JOptionPane.showMessageDialog(null, "Connection Failed!!!!!");
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null,exc);
			return null;
		}
		
	}
	
}
