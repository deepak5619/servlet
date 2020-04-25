package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParidhiPhoto extends HttpServlet {
   public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	   PrintWriter pw=null;
	   pw=res.getWriter();
	   res.setContentType("text/html");
	   String name=req.getParameter("choose");
	   if(name.equals("paridhi")) {
		   pw.println("<body bgcolor='aqua'>"
			   		+ "<br><h1 style='text-align:center'>-:: Paridhi's photo ::-</h1>"
			   		+ "<br><p style='text-align:center'><img src='paridhi/pari1.jpg' style='height:350;width:300'></p>"
			   +"<br><p style='text-align:center'><img src='paridhi/pari2.jpeg' style='height:300;width:300'></p>"
			   +"<br><p style='text-align:center'><img src='paridhi/pari3.jpeg' style='height:300;width:300'></p>"
			   +"<br><p style='text-align:center'><img src='paridhi/pari4.jpeg' style='height:300;width:300'></p>"
			   +"<br><p style='text-align:center'><img src='paridhi/pari5.jpeg' style='height:300;width:300'></p>"
			   +"<br><p style='text-align:center'><img src='paridhi/pari6.jpeg' style='height:300;width:300'><br>"
			   + "<h1 style='color:red ;text-align:center'><b>Thanku ji !</b></h1></p>"
			   + "</body>");
	   }
	   else if(name.equals("preeti")) {
		   pw.println("<body bgcolor='aqua'>"
		   		+ "<br><h1 style='text-align:center'>-:: Preeti's photo ::-</h1>"
		   		+ "<br><p style='text-align:center'><img src='lizards/1f98e.jpg' style='height:300;width:300'></p>"
		   +"<br><p style='text-align:center'><img src='lizards/lizard_1.jpg' style='height:300;width:300'></p>"
		   +"<br><p style='text-align:center'><img src='lizards/chhipkli_2.jpg' style='height:300;width:300'></p>"
		   +"<br><p style='text-align:center'><img src='lizards/File_photo_3.jpeg' style='height:300;width:300'></p>"
		   +"<br><p style='text-align:center'><img src='lizards/mouse.jpg' style='height:300;width:300'></p>"
		   +"<br><p style='text-align:center'><img src='lizards/rat_1f400.jpg' style='height:300;width:300'><br><br>"
		   + "<a href='photo.html'><h1 style='color:red ;text-align:center'><b>Sorry ji !!</b></h1></a></p>"
		   + "</body>");
	   }
	   pw.println("<h1><p style='text-align:center'><a href='home.html'>Back</a></p></h1>");
	   
   }
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		doGet(req,res);
   }
}