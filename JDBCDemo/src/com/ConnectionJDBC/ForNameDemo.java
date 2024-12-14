package com.ConnectionJDBC;

import java.sql.DriverManager;

class Demo{
	static {
		System.out.println("In static Block");
	}
	
	{
		System.out.println("In instance Block");
	}
}

public class ForNameDemo {
	public static void main(String[] args) {
		//Demo d = new Demo(); //Instantiation load both static and instance block or resource
		
		//What if we want to load only static resources, not instance block
		//Then we use forName method from Class class itself
		try {
			//Class.forName("com.ConnectionJDBC.Demo");
			
			//Now if we want to get class as well as instance from the class, we run newInstance method on same class loaded by forName method
			
			Class.forName("com.ConnectionJDBC.Demo").newInstance();
			
			//DriverManager.registerDriver(new com.mysql.cj.Driver());
			
			//We don't have do load register driver explicitly, there is static inside Driver calss which does it for us, so we just load that block
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


