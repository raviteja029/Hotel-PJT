package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FeedbackBean;

/**
 * Servlet implementation class for Servlet: FeedbackServlet
 *
 */
 public class FeedbackServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public FeedbackServlet() {
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
		
		String name = request.getParameter("feedbackUsername"); 
		String contact = request.getParameter("feedbackContact"); 
		String comment= request.getParameter("feedbackContent");
		
		FeedbackBean fb= new FeedbackBean();
		fb.setUname(name);
		fb.setContact(contact);
		fb.setComment(comment);
		
		boolean flag=fb.updateFeedback();
		System.out.print(flag);
		if(flag==true)
		{
			response.sendRedirect("afterfeedback.html");
		}
		else
		{ 
			response.sendRedirect("feedback.html");
		}
		
		
		
		
	}   	  	    
}