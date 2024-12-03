package com.myProjectDemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet; 
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/add")
public class AddServlet extends HttpServlet{
	//public service (req, res) by default call doGet and doPsost according to need
//	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		PrintWriter out = res.getWriter();
//		int a = Integer.parseInt(req.getParameter("num1"));
//		int b = Integer.parseInt(req.getParameter("num2"));
//		int c = a + b;
//		out.println("Welcome man! Result is " + c);
//	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		int a = Integer.parseInt(req.getParameter("num1"));
		int b = Integer.parseInt(req.getParameter("num2"));
		int c = a + b;
		out.println("Welcome man! Result is " + c);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		int a = Integer.parseInt(req.getParameter("num1"));
		int b = Integer.parseInt(req.getParameter("num2"));
		int c = a + b;
		//out.println("Welcome man! Result is " + c);
		//Request dispatching from Redirect dispatch
//		req.setAttribute("sum", c); //passing value with request object
//		RequestDispatcher rqd = req.getRequestDispatcher("/sq"); //getting RequestDispatche object
//		rqd.forward(req, res); //forwarding request
		
		//Redirect Request client sends two request one to first servlet and second to another servlet
//		res.sendRedirect("sq?k="+c); //redirecting request and this is url rewriting
		//tehre are theree concept of session management i) Session ii) Cookies iii) URL rewriting
		
		
		//Session
//		HttpSession session = req.getSession();
//		session.setAttribute("k", c);
//		res.sendRedirect("sq");
		
		//Cookie
		Cookie cookie = new Cookie("k", c+""); //cookie receive values even in string
		res.addCookie(cookie);
		res.sendRedirect("sq");
	}
}
