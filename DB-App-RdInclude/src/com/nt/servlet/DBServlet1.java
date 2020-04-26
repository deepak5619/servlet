package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/dburl1")
public class DBServlet1 extends HttpServlet {
	private static final String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		int eno=Integer.parseInt(req.getParameter("empno"));
		int empno;
		String name,job;
		Float sal;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String driver=null,url=null,user=null,pwd=null;
		ServletContext sc=null;
		sc=getServletContext();
		RequestDispatcher rd1=sc.getRequestDispatcher("/headerurl");
		RequestDispatcher rd2=sc.getRequestDispatcher("/footer.html");
		
		driver=sc.getInitParameter("driver");
		url=sc.getInitParameter("url");
		user=sc.getInitParameter("user");
		pwd=sc.getInitParameter("pwd");
		try {
			
			Class.forName(driver);
		    con=DriverManager.getConnection(url,user,pwd);
		    if(con!=null)
		    	ps=con.prepareStatement(query);
		    if(ps!=null) {
		    	ps.setInt(1, eno);
		    	rs=ps.executeQuery();
		    }
		    if(rs!=null) {
			    if(rs.next()) {
			    	empno=rs.getInt(1);
			    	name=rs.getString(2);
			    	job=rs.getString(3);
			    	sal=rs.getFloat(4);
			        rd1.include(req, res);
			    	pw.println("<body bgcolor='aqua'>");
				    pw.println("<h1 style='color:blue ; text-align:center'>employee no::"+empno+"</h1>");
				    pw.println("<h1 style='color:blue ; text-align:center'>employee name::"+name+"</h1>");
				    pw.println("<h1 style='color:blue ; text-align:center'>employee job::"+job+"</h1>");
				    pw.println("<h1 style='color:blue ; text-align:center'>employee sallery::"+sal+"</h1>");
			    }
			    else
			    	pw.println("<body bgcolor='aqua'><h1 style='color:red ; text-align:center'><marquee>Employee is not present</marquee></h1>");
			    pw.println("<br><br><p style='text-align:center'><a href='home.html'>home</a></p></body>");
		        rd2.include(req,res);
		    }
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
