package controller;

import model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import model.User_validates;

/**
 * Servlet implementation class for Servlet: user_validate
 *
 */
 public class user_validate extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public user_validate() {
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
		HttpSession ses =request.getSession(true);
	
		String canceldummy = (String) ses.getAttribute("canceldummy");
		
		System.out.println("firstone");
		String uname= request.getParameter("email");
		String pass= request.getParameter("pass");
		ses.setAttribute("email",uname);
		ses.setAttribute("password", pass);
		
		System.out.println("first");
		User_validates uv = new User_validates();
		
		
		//doubt what for i need this?
		uv.setAdminName(uname);
		uv.setPassword(pass);
		
		boolean flag=uv.checkAuthentication();
		System.out.print(flag);
		if(flag==true)
		{
			if(canceldummy == "true")
			{
				ses.setAttribute("canceldummy", "false");
				response.sendRedirect("userhistory.jsp");
				
			}
			else
			{
			response.sendRedirect("extras.html");
			}
		}
			
		
			else
			{
				response.sendRedirect("mismatch.html;");
			}
		}
			
	}   	  	    
