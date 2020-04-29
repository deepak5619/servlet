package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
	PrintWriter pw=null;
    pw=res.getWriter();
    res.setContentType("text/html");
    String name=null,fname=null,mstatus=null;
    name=req.getParameter("name");
    fname=req.getParameter("fname");
    mstatus=req.getParameter("ms");
    if(mstatus.equals("single")) {
    	pw.println("<form action='secondurl' method='POST'>");
    	pw.println("<table align='center' bgcolor='pink'>");
    	pw.println("<tr><td>when to marry</td><td><input type='text' name='f2v1'></td></tr>");
    	pw.println("<tr><td>why to marry</td><td><input type='text' name='f2v2'></td></tr>");
    	pw.println("<input type='hidden' name='hname' value='"+name+"'>");
    	pw.println("<input type='hidden' name='hfname' value='"+fname+"'>");
    	pw.println("<input type='hidden' name='hms' value='"+mstatus+"'>");
    	pw.println("<tr><td><colspan='2'><input type='submit' value='register'></td></tr>");
    	pw.println("</table></form>");
    }
    else {
    	pw.println("<form action='secondurl' method='POST'>");
    	pw.println("<table align='center' bgcolor='pink'>");
    	pw.println("<tr><td>name of spouse</td><td><input type='text' name='f2v1'></td></tr>");
    	pw.println("<tr><td>number of children</td><td><input type='text' name='f2v2'></td></tr>");
    	pw.println("<input type='hidden' name='hname' value='"+name+"'>");
    	pw.println("<input type='hidden' name='hfname' value='"+fname+"'>");
    	pw.println("<input type='hidden' name='hms' value='"+mstatus+"'>");
    	pw.println("<tr><td><colspan='2'><input type='submit' value='register'></td></tr>");
    	pw.println("</table></form>");
    }
    pw.close();
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
    	doGet(req,res);
    }
}
