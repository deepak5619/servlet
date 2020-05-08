package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    HttpSession ses=req.getSession(true);
    ses.setAttribute("name",name);
    ses.setAttribute("fname",fname);
    ses.setAttribute("mstatus", mstatus);
    
    if(mstatus.equals("single")) {
    	pw.println("<form action='"+res.encodeURL("secondurl")+"' method='POST'>");  //url rewritting  enables us to send the ses object to the another servlet through url
    	pw.println("<br><h1 style='color:red ;text-align:center'>Enter your plan to marry</h1>"); //if we disable the cookies then also it enables us to do the session tracking
    	pw.println("<br><table align='center' bgcolor='pink'>");
    	pw.println("<tr><td>when to marry</td><td><input type='text' name='f2v1'></td></tr>");
    	pw.println("<tr><td>why to marry</td><td><input type='text' name='f2v2'></td></tr>");
    	pw.println("<tr><td><colspan='2'><input type='submit' value='register'></td></tr>");
    	pw.println("</table></form>");
    }
    else {
    	pw.println("<form action='"+res.encodeURL("secondurl")+"' method='POST'>");
    	pw.println("<br><h1 style='color:red;text-align:center'>Enter your marriage info</h1>");
    	pw.println("<br><table align='center' bgcolor='pink'>");
    	pw.println("<tr><td>name of spouse</td><td><input type='text' name='f2v1'></td></tr>");
    	pw.println("<tr><td>number of children</td><td><input type='text' name='f2v2'></td></tr>");
    	pw.println("<tr><td><colspan='2'><input type='submit' value='register'></td></tr>");
    	pw.println("</table></form>");
    }
    pw.close();
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
    	doGet(req,res);
    }
}
