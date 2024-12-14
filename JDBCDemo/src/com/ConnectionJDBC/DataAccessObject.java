package com.ConnectionJDBC;
//DAO -- Data access object used to fetch data from database without knowing lower layer database details
import java.sql.*;
import com.ConnectionJDBC.Connect;

class Student{
	int rollNo;
	String name;
}

class StudentDAO{
	public Student getStudent(int rollNo) {
		Student s = new Student();
		s.rollNo = rollNo;
		Connection conn = new Connect().getConnection();
		
		String query = "SELECT name FROM students WHERE studentId=" + rollNo;
		
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			s.name = rs.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to fetch student data properly! Try again!");
			e.printStackTrace();
		}
		
		return s;
	}
	
	public void addStudent(Student s) {
		Connection conn = new Connect().getConnection();
		
		String query = "INSERT INTO students VALUES(?,?)";
		
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1, s.rollNo);
			pst.setString(2, s.name);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error preparing statement");
			e.printStackTrace();
		}
		
	}
}
public class DataAccessObject {
	public static void main(String [] args) {
		StudentDAO dao = new StudentDAO();
		Student s1 = dao.getStudent(1);
		System.out.println(s1.name);
		
		Student s2 = new Student();
		s2.rollNo = 6;
		s2.name = "Mr.Kicky";
		dao.addStudent(s2);
	}
}
