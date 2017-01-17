package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SignupBean;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String name=request.getParameter("mem_name");
		
		String mailId=request.getParameter("mem_mailid");
		
		String rel_nam=request.getParameter("rel_name");
		
		AddMemberBean am = new AddMemberBean();
		
		am.setAttributes(name, mailId,rel_nam);
		
		boolean flag=.checkEmail();
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
