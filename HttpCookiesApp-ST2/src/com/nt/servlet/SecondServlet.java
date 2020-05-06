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
	    
	    String name=null,fname=null,mstatus=null,f2v1=null,f2v2=null;
	    name=cookies[0].getValue();
	    fname=cookies[1].getValue();
	    mstatus=cookies[2].getValue();
	    f2v1=req.getParameter("f2v1");
	    f2v2=req.getParameter("f2v2");
	    pw.println("form 1 req data  :: "+name+"  "+fname+"  "+mstatus);
	    pw.println("<br>form 2 req data  :: "+f2v1+"  "+f2v2);
	    pw.println("<br><a href='input.html'>home</a>");
	    pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
