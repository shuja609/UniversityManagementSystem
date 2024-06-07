package sample;

import java.sql.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class sqliteConnection {
	Connection conn=null;
	public static Connection dbConnector() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String urllink = "jdbc:mysql://localhost:3306/sda_project";
			String myname = "root";
			String password = "sql@123";
			Connection conn=DriverManager.getConnection(urllink, myname, password);
			return conn;
			
			


		}
		catch(Exception exc) 
		{
			exc.printStackTrace();
			return null;
		}
		
	}
	
}
