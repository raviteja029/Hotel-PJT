<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="model.BookedhistoryBean;"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booked History</title>
<link rel="stylesheet" type="text/css" href="calendar.css" />
</head>
<body id="main">
<img id="im" src="images/Royal_Castle_29267.gif" />


<div id="two">


 <br>
 <center><h2> USER BOOKING HISTORY  </h2></center>
 <br>

<%
        HttpSession ses = request.getSession(true);
		String uname = (String)ses.getAttribute("username");
				
		if(uname == null)
		{
			out.println("<center>");
			out.println("<em><b>SORRY!! YOU ARE NOT LOGGED IN</b></em>");	
			out.println("<br><br><br>");
			out.println("<form action='Historylogin' method='post'>");
			out.println("<input type='submit' value ='Click to login'></form>");
			out.println("</center>");
			
			
		}
		else
		{
		BookedhistoryBean bhb=new BookedhistoryBean();     
				
		bhb.setUsername(uname);
		String bookedhistory = bhb.returnbookedhistory();
		
		out.println(bookedhistory);
		}

%>

<br><br>

		<center><u><a href="index.html" > Go back </a></u></center>


</div>





</body>
</html>