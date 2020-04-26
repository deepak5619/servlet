package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/centralurl")
public class CentralServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw;
		pw=res.getWriter();
		res.setContentType("text/html");
		String ptype=null;
		ptype=req.getParameter("ptype");
		float cost=Float.parseFloat(req.getParameter("cost"));
		float cgst=0.0f;
		
		if(ptype.equalsIgnoreCase("product")) {
			cgst=cost*0.18f;
			pw.println("<h1 style='color:purple ; text-align:center' >Central GST = "+cgst+"</h1>");
			
		}
		else if(ptype.equalsIgnoreCase("service")) {
			cgst=cost*0.15f;
			pw.println("<h1 style='color:purple ; text-align:center' >Central GST = "+cgst+"</h1>");
			
		}
		else if(ptype.equalsIgnoreCase("startup")) {
	        cgst=cost*0.08f;
	        pw.println("<h1 style='color:purple ; text-align:center' >Central GST = "+cgst+"</h1>");
			
		}
		//set cgst value to attr1 in request object
		req.setAttribute("Attr1",cgst);
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
