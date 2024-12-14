package com.ConnectionJDBC;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class Connect {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/testjdbc";
			String userName = "root";
			String userPassword = "";
			
			Connection conn = DriverManager.getConnection(url,userName,userPassword);
			
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error loading driver");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Connecting DB");
			e.printStackTrace();
		}
		return null;
		
	}
}
