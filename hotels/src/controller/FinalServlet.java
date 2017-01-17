package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ConfirmationBean;

/**
 * Servlet implementation class for Servlet: FinalServlet
 *
 */
 public class FinalServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public FinalServlet() {
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
		System.out.println("inside final servlet");
		HttpSession ses =request.getSession(true);
		
		String name1=(String)ses.getAttribute("username");
		//String roomType=(String) ses.getAttribute("userchoice");
		String date1=(String) ses.getAttribute("date1");
		String date2=(String) ses.getAttribute("date2");
		int diff=(Integer) ses.getAttribute("diff");
		int extra_amt=(Integer) ses.getAttribute("extra_amt");
		int transkey=(Integer) ses.getAttribute("transKey");
		String rooms_selected=(String) ses.getAttribute("roomType");
		int cost=(Integer) ses.getAttribute("cost");
		System.out.println("inside final servlet dfgdfgdfgdfgdfgdf");
		
		ConfirmationBean cb=new ConfirmationBean();
		//System.out.println("inside final servlet");
		cb.setName(name1);
		cb.setRoomtype(rooms_selected);
		cb.setDate1(date1);
		cb.setDate2(date2);
		cb.setdaysstayed(diff);
		cb.setcost(cost);
		cb.setExtraamt(extra_amt);
		cb.setRoomtype(rooms_selected);
		cb.settranskey(transkey);
		System.out.println("before DBupdate");
		cb.updateDB();
		response.sendRedirect("index.html");
		
		
		
	}   	  	    
}