package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String pval=null;
		 Locale locales[]=null;
		// get PrintWriter
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //get All available Locales of this world
		 locales=Locale.getAvailableLocales();
		 //read special request param value (l1)
		 pval=req.getParameter("l1");
		 //differentiate logic based on the additional req param value
		 if(pval.equalsIgnoreCase("link1")) {
			 pw.println("<h1 style='color:red;text-align:center'> All Languages are </h1>");
			 for(Locale l:locales) {
				 pw.println("<b>"+l.getDisplayLanguage()+"</b><br>");
			 }
		 }
		 else if(pval.equalsIgnoreCase("link2")) {
			 pw.println("<h1 style='color:red;text-align:center'> All Countries are </h1>");
			 for(Locale l:locales) {
				 pw.println("<b>"+l.getDisplayCountry()+"</b><br>");
			 }
		 }
		 else {
			 pw.println("<h1 style='color:red;text-align:center'>Date and Time ::"+new java.util.Date()+"</h1>");
		 }
		 //add home hyperlink
		 pw.println("<br><br><a href='links.html'><img src='images/home.png' width='50' height='50'></a>");
	 //close stream
		 pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   doGet(req,res);
	}//doPost(-,-)
}//class
