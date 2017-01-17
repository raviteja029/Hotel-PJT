package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminvalidateBean;

/**
 * Servlet implementation class for Servlet: AdminvalidateServlet
 *
 */
 public class AdminvalidateServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AdminvalidateServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String adminName=request.getParameter("user");
		String adminPassword=request.getParameter("pass");
		
		HttpSession ses =request.getSession(true);
		ses.setAttribute("adminuname",adminName);
		
		
		AdminvalidateBean av=new AdminvalidateBean();
		av.setAdminName(adminName);
		av.setPassword(adminPassword);
		boolean flag=av.checkAuthentication();
		if(flag==true)
		{
			response.sendRedirect("admin_availability.html");
		}
		else
		{
			response.sendRedirect("erroradmin.html");
		}
		
	}   	  	    
}