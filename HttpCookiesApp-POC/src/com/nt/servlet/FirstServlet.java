package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		ck1=new Cookie("ap","amarawati");
		ck2=new Cookie("mh","maharashtra");
		res.addCookie(ck1);//inmemory cookies
		res.addCookie(ck2);//inmemory cookies
		
		ck3=new Cookie("bp","bhopal");
		ck4=new Cookie("up","uttarPradesh");
		ck3.setMaxAge(60);//set expiry time
		ck4.setMaxAge(120);//set expiry time
		res.addCookie(ck3);//persistent cookies
		res.addCookie(ck4);//persistent cookies
		pw.println("Cookies are created and stored");
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
