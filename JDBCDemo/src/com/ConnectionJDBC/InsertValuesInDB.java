package com.ConnectionJDBC;
import java.sql.*;
public class InsertValuesInDB {
	public static void main(String args[]){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testjdbc";
			String userName = "root";
			String userPassword = "";
			
			Connection conn = DriverManager.getConnection(url,userName,userPassword);
			
			//Statement st = conn.createStatement();
			
			//String personName = "Mr.Homelander";
			//String query = "INSERT INTO students (name) VALUES('" + personName + "');";
			
			//If query have lots of dynamic values, we will use prepare statement to feed dynamic values
			//Instead of statement, we will use prepare statement
			
			//executeUpdate is used for DML, insert, update, delete data, return number of row affected(int)
			//int countRowAffected = st.executeUpdate(query);
			//System.out.println(countRowAffected + " row(s) affected.");
			
			int rollNo = 5;
			String name = "Mr.Ryan";
			String query = "INSERT INTO students(studentId,name) VALUES(?,?)";
			//4.Instead of statement, we use prepare statement to accomodate dynamic values during insert or update
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, rollNo);
			st.setString(2, name);
			
			int countRowAffected = st.executeUpdate(); //we already passed query earlier, we don't need add it again during execution
			System.out.println(countRowAffected + " row(s) affected.");
			//7.closing
			st.close(); //closing statement
			conn.close(); //closing connection
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}