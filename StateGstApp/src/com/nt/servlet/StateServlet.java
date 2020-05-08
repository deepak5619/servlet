package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/stateurl")
public class StateServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
//		get current web application Servlet Context
		ServletContext sc=getServletContext();
//		get neighbour web application servlet context
		ServletContext sc1=sc.getContext("/CentralStateGstApp");
		RequestDispatcher rd=sc1.getRequestDispatcher("/centralurl");
		String name=null;
		String pname=null;
		String ptype=null;
		float sgst=0.0f;
		float cgst=0.0f;
		float total=0.0f;
		float cost=Float.parseFloat(req.getParameter("cost"));
		
		name=req.getParameter("name");
		pname=req.getParameter("pname");
		ptype=req.getParameter("ptype");
		
		pw.println("<h1 style='color:red ; text-align:center' >State and central GST Detalis</h1>");
		pw.println("<h1 style='color:purple ; text-align:center' >Company name = "+name+"</h1>");
		pw.println("<h1 style='color:purple ; text-align:center' >Project name = "+pname+"</h1>");
		pw.println("<h1 style='color:purple ; text-align:center' >Project type = "+ptype+"</h1>");
		
		if(ptype.equalsIgnoreCase("product")) {
			sgst=cost*0.12f;
			pw.println("<h1 style='color:purple ; text-align:center' >State GST = "+sgst+"</h1>");
		}
		else if(ptype.equalsIgnoreCase("service")) {
			sgst=cost*0.08f;
			pw.println("<h1 style='color:purple ; text-align:center' >State GST = "+sgst+"</h1>");
		}
		else if(ptype.equalsIgnoreCase("startup")) {
	        sgst=cost*0.05f;
	        pw.println("<h1 style='color:purple ; text-align:center' >State GST = "+sgst+"</h1>");
			
		}
		rd.include(req,res);
		//get the cgst of centralServlet in CentralStateGstApp
		cgst=(float) req.getAttribute("Attr1");
	    total=sgst+cgst;
	
		pw.println("<h1 style='color:purple ; text-align:center' >Total GST = "+total+"</h1>");
		pw.println("<p style='text-align:center'><a href='home.html' >home</a></p>");
	 }

	    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
