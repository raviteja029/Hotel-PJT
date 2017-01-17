package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cancelBean;

/**
 * Servlet implementation class for Servlet: cancelServlet
 *
 */
 public class cancelServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public cancelServlet() {
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
		String userName=request.getParameter("cancel_username");
		String transKey=request.getParameter("cancel_transkey");
		cancelBean cb=new cancelBean();
		cb.setUsername(userName);
		cb.setTranskey(transKey);
		boolean flag=cb.deleteRecords();
		if(flag==true)
		response.sendRedirect("aftercancel.html");
		else 
		response.sendRedirect("errorcancel.html");
	}   	  	    
}