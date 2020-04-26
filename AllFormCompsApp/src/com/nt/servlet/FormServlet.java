package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,gender=null,ms=null,hobies[]=null,crs[]=null,color=null,emailId=null,url=null,qlfy=null,dob=null,week=null,month=null;
		 int age=0,salary=0;  
		long mobileNo=0;
		
		
		 //get Printwriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		mobileNo=Long.parseLong(req.getParameter("phoneNo"));
		gender=req.getParameter("gender");
		addrs=req.getParameter("addrs");
		url=req.getParameter("fbUrl");
		qlfy=req.getParameter("qlfy");
		emailId=req.getParameter("email");
		crs=req.getParameterValues("courses");
		if(crs==null) {
			crs=new String[] {"air force-wastefellow"};
		}
	    hobies=req.getParameterValues("hb");
	    color=req.getParameter("fColor");
	    dob=req.getParameter("dob");
	    salary=Integer.parseInt(req.getParameter("salary"));
	    month=req.getParameter("mob");
	    ms=req.getParameter("ms");
		 if(ms==null)
			ms="single";
	    week=req.getParameter("fweek");
	    //write req processing logics
	    if(gender.equalsIgnoreCase("m")) {
	    	if(age<5) 
	    	    pw.println("<br><b> Master."+name+" u r baby boy");
	    	else if(age<12)	    	    
	    		pw.println("<br><b> Master."+name+" u r small boy");
	    	else if(age<19)
	    		pw.println("<br><b> Master./Mr."+name+" u r teenage boy");
	    	else if (age<35)
	    		pw.println("<br><b> /Mr."+name+"  u r young man");
	    	else if(age<50)
	    		pw.println("<br><b> /Mr."+name+" u r middle aged man ");
	    	else 
	    		pw.println("<br><b> /Mr."+name+" u r Budda ");
	    }
	    else {
	    	if(age<5) 
	    	    pw.println("<br><b> Master."+name+" u r baby girl");
	    	else if(age<12)	    	    
	    		pw.println("<br><b> Master."+name+" u r little girl");
	    	else if(age<19) {
	    		  if(ms.equalsIgnoreCase("married"))
	    		     pw.println("<br><b> Mrs."+name+" u r teenage girl ");
	    		  else
	    			  pw.println("<br><b> Miss/Master."+name+" u r teenage girl ");
	    	}
	    	else if (age<35)
	    	{
	    		  if(ms.equalsIgnoreCase("married"))
	    		     pw.println("<br><b> Mrs."+name+" u r young woman ");
	    		  else
	    			  pw.println("<br><b> Miss."+name+" u r young lady ");
	    	}
	    	else if(age<50) {
	    		 if(ms.equalsIgnoreCase("married"))
	    		     pw.println("<br><b> Mrs."+name+" u r middle-aged woman ");
	    		  else
	    			  pw.println("<br><b> Miss."+name+" u r Middle-aged woman ");
	    	}
	    	else { 
	    		 if(ms.equalsIgnoreCase("married"))
	    		     pw.println("<br><b> Mrs."+name+" u r old woman ");
	    		  else
	    			  pw.println("<br><b> Miss."+name+" u r old woman ");
	    	}
	    }
	    
	    //display form data
	    pw.println("<b> name:::"+name+"</b><br>");
	    pw.println("<b> age:::"+age+"</b><br>");
	    pw.println("<b> gender:::"+gender+"</b><br>");
	    pw.println("<b> Marital STatus:::"+ms+"</b><br>");
	    pw.println("<b> address:::"+addrs+"</b><br>");
	    pw.println("<b> ContactNo:::"+mobileNo+"</b><br>");
	    pw.println("<b> FB Url:::"+url+"</b><br>");
	    pw.println("<b> Email:::"+emailId+"</b><br>");
	    pw.println("<b> DOB:::"+dob+"</b><br>");
	    pw.println("<b> Courses:::"+Arrays.toString(crs)+"</b><br>");
	    pw.println("<b> Hobies:::"+Arrays.toString(hobies)+"</b><br>");
	    pw.println("<b> Qualification:::"+qlfy+"</b><br>");
	    pw.println("<b> Salary :::"+salary+"</b><br>");
	    pw.println("<b> Faviorite Color:::"+color+"</b><br>");
	    pw.println("<b> Month of birth:::"+month+"</b><br>");
	    pw.println("<b> Faviorite Week:::"+week+"</b><br>");
	    //add hyperlink
	    pw.println("<br> <a href='form.html'>home </a> ");
	    
	    //close strea
	    pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
	}

}
