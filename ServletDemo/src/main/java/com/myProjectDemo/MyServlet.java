package com.myProjectDemo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("Hello ");
		//Context is global object available for all servlet
//		ServletContext ctx= getServletContext();
//		String name = ctx.getInitParameter("name");
//		String phone = ctx.getInitParameter("phone");
//		out.println(name + ", you have " + phone + " device!");
		
		//ServletConfig is specific to any specific servlet
		
		ServletConfig cg = getServletConfig();
		String name = cg.getInitParameter("name");
		String phone = cg.getInitParameter("phone");
		out.println(name + ", you have " + phone + " device!");
	}
}
