package com.myProjectDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
@WebServlet("/sq")
public class SquareServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		//Accepting values from request redirect dispatch
		//getting attribute from request object
//		int k = (int) req.getAttribute("sum");
//		int sq = k*k;
//		out.println("Square Result = " + sq);

		out.println("Redirect page!");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		
		//URL rewriting retrieve
		//int k = Integer.parseInt(req.getParameter("k"));
		
		//session retrieve
//		HttpSession session = req.getSession();
//		int k = (int)session.getAttribute("k");
//		session.removeAttribute("k"); //removing session values
		
		//cookie retrieve
		int k = 0;
		Cookie cookies[] = req.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("k"))
				k = Integer.parseInt(c.getValue());
		}
		int sq = k*k;
		out.println("Redirect page! Square = " + sq);
	}
}
