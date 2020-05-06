package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		Cookie cookies[]=null; 
		cookies=req.getCookies();
		pw.println("displaying cookies");
		if(cookies!=null) {
		 pw.println("<table>");
		 pw.println("<tr><th>cookies name</th><th>cookies value</th></tr>");
		 for(Cookie ck:cookies) {
			pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
		 }
		 pw.println("</table>");
		}
		else
			pw.println("cokies not found");
		 pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
