package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SignupBean;

/**
 * Servlet implementation class for Servlet: SignupServlet
 *
 */
 public class SignupServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
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
		
		System.out.println("inside servlet");
		String name=request.getParameter("signup_name");
		
		String mailId=request.getParameter("signup_mailid");
		
		String mobile=request.getParameter("signup_mobile");
		
		String aadharID=request.getParameter("signup_aadharID");
		
		String password=request.getParameter("signup_password");
		
		String address=request.getParameter("signup_address");
		
		String city=request.getParameter("signup_city");
		
		String state=request.getParameter("signup_state");
		
		String country=request.getParameter("signup_country");
		System.out.println("before bean");
		SignupBean sb=new SignupBean();
		System.out.println("after bean");
		sb.setAttributes(name, mailId, mobile, aadharID, password, address, city, state, country);
		System.out.println("attributes set");
		boolean flag=sb.checkEmail();
		System.out.println("after check email");
		if(flag==false)
		{
			response.sendRedirect("errorsignup.html");
			
		}
		else
		{
			sb.updateTable();
			response.sendRedirect("signin.html");
		}
		
		
		
		
		
		
		
		
		
		
		
	}   	  	    
}