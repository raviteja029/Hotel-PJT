package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SendAP;
import model.ConfirmationBean;
import model.User_validates;

/**
 * Servlet implementation class for Servlet: ExtraServlet
 *
 */
 public class ExtraServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ExtraServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}  	
	
	/* (non-Java-doc)e
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses =request.getSession(true);
		ses.setAttribute("pickup", request.getParameter("pickup"));
		ses.setAttribute("drop", request.getParameter("drop"));
		
		String name1=(String)ses.getAttribute("username");
		String roomType=(String) ses.getAttribute("userchoice");
		String date1=(String) ses.getAttribute("date1");
		String date2=(String) ses.getAttribute("date2");
		//System.out.println(name1);
		
        int transKey;
		int extras1=Integer.parseInt(request.getParameter("pickup"));
		int extras2=Integer.parseInt(request.getParameter("drop"));
		
		int extra_amt=0;
		if(extras1==1)
		{   
			//flag_pick=1;
			extra_amt++;
		}
		if(extras2==1)
		{
			//flag_drop=1;
			extra_amt++;
		}
		extra_amt*=1000;
		System.out.println(extra_amt);
		ses.setAttribute("extra_amt", extra_amt);
		ConfirmationBean cb=new ConfirmationBean();
		cb.setExtra1(extras1);
		cb.setExtra2(extras2);
		cb.setExtraamt(extra_amt);
		cb.setRoomtype(roomType);
		cb.setDate1(date1);
		cb.setDate2(date2);
		//User_validates uv=new User_validates();
		//uv.setAdminName(name1);
		//System.out.println("in servlet"+name1);
		//String uname=uv.getAdminName();
		cb.setName(name1);
		int diff=cb.calculateDate(date1, date2);
		ses.setAttribute("diff",diff);
		int cost=cb.calculateCost(diff);
		ses.setAttribute("cost", cost);
		//System.out.println("roomCost"+roomCost);
		transKey= cb.generateKey();		
		ses.setAttribute("transKey", transKey);
					
		System.out.println("b4 created");
		response.sendRedirect("confirmation.jsp");
	
		
		//cb.updateDB();
		
		/*	SendAP sa=new SendAP();
		System.out.println("object created");
		sa.setAttributes(transKey,date1,date2,cost,extra_amt,diff);
		sa.setName(name1);
		sa.getMailID();*/
		
		
		
	
		
		
	}   	  	    
}