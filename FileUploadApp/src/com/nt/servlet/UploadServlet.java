package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class UploadServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		MultipartFormDataRequest nreq=null;
		UploadBean bean=null;
		Vector vector=null;
		UploadParameters param=null;
		
		try {
			//create MultipartFormDataRequest
			nreq=new MultipartFormDataRequest(req);
			//perform File Uploading
			bean=new UploadBean();
			
			bean.setFolderstore("E:/files_stored");
			//restriction
			bean.setOverwrite(false);
			bean.setMaxfiles(10);
			bean.setFilesizelimit(30*1024);
			bean.setBlacklist("*.exe,*.jpg");
			//upload files
			bean.store(nreq);
			
			pw.println("<h1 style='color:green' ;'text-align:center'>Files are uploaded</h1>");
			vector =bean.getHistory();
			for(int i=0;i<vector.size();i++) {
				param=(UploadParameters)vector.elementAt(i);
				pw.println("<br><br>file::"+param.getFilename()+" size::"+param.getFilesize()+" type:: "+param.getContenttype());
			}
		
		}
		catch(Exception e) {
			pw.println("files not uploaded"+e.getMessage());
			e.printStackTrace();
		}
		pw.println("<p style='text-align:center'><a href='home.html'>home</a></p>");
		pw.close();
	}
		
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req, res);
		}
}
