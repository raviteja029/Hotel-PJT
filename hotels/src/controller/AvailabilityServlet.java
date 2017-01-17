package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AvailabilityBean;
import model.ConfirmationBean;
/**
 * Servlet implementation class for Servlet: AvailabilityServlet
 *
 */
 public class AvailabilityServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AvailabilityServlet() {
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
		String checkin=request.getParameter("datum1");
		String checkout=request.getParameter("datum2");
		int choice=Integer.parseInt(request.getParameter("types"));
		String room_selected;

		HttpSession ses =request.getSession(true);
		ses.setAttribute("date1", request.getParameter("datum1"));
		ses.setAttribute("date2", request.getParameter("datum2"));
		ses.setAttribute("canceldummy", "false");
		ses.setAttribute("userchoice", request.getParameter("types"));
		String uname = (String)ses.getAttribute("username");

		if(choice==1)
			room_selected="eco";
		else if(choice==2)
			room_selected="dlx";
		else if(choice==3)
			room_selected="club";
		else
			room_selected="suite";
		ses.setAttribute("roomType",room_selected);
		ConfirmationBean cb=new ConfirmationBean();
		if(cb.validateDate(checkin, checkout)==false)
		{
			response.sendRedirect("dateInvalid.html");
		}
		else
		{
		AvailabilityBean ab= new AvailabilityBean();
		ab.setChkin(checkin);
		ab.setChkout(checkout);
		ab.setRoomselected(room_selected);
		boolean flag= ab.checkAvailability();
		if(flag==true)
		{
			response.sendRedirect("errorpage.html");
		}
		
			else
			{
				if(uname == null)
				{
					response.sendRedirect("signin.html;");
				}
				else
				{
					response.sendRedirect("extras.html;");
				}
			}
		}
		
	}
	}   	
	

