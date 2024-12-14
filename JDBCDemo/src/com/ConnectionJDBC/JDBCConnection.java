package com.ConnectionJDBC;

//1. import packages
import java.sql.*; //-- since our java is more than 9, we use module
import java.util.Date;

public class JDBCConnection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//2 Load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//3.Connection establishment
		//working with jdbc and database we are working is mysql
		String url = "jdbc:mysql://localhost:3306/testjdbc"; //database name is testjdbc
		String userName = "root";
		String userPassword = "";
		
		Connection conn = DriverManager.getConnection(url,userName,userPassword); //getConnection is static method of DriverManager() return instance of connection
		
		//4.Statement preparation
		Statement st = conn.createStatement();
		
		//DDL is used for creating table
		
		//Execute the query
		//String query = "SELECT * FROM students WHERE studentId=3";
		String query = "SELECT * FROM students";	
		
		//executeQuery used for DQL, querying -- return records (result)
		ResultSet rs = st.executeQuery(query);
		
		//6. Processing result
//		rs.next(); //generally moves to next row
//		int rollNo = rs.getInt(1); //getting data in first column, since first column is student id and integer type we are using in
//		String name = rs.getString(2);
//		System.out.println("roll no = " + rollNo + ", name = " + name);
		
		//we can also extract column by its name
//		System.out.println(rs.getInt("studentId"));
//		System.out.println(rs.getString("name"));
//		
		
		while(rs.next()) {
			System.out.println("Roll No = " + rs.getInt(1) + ", name = " + rs.getString(2));
		}
		//7.closing
		st.close(); //closing statement
		conn.close(); //closing connection
	}
}
