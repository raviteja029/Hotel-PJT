<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="model.AdmincancelledBean;"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Cancelled</title>
<link rel="stylesheet" type="text/css" href="calendar.css" />
</head>
<body id="main">
<img id="im" src="images/Royal_Castle_29267.gif" />


<div id="two">

 <br>
 <center><h2> CANCELLED  </h2></center>
 <br>
<%
              AdmincancelledBean acb=new AdmincancelledBean();     
           
            String allcancelled = acb.returnCancelled();
            out.println(allcancelled);
        %>

<br><br>

<center><u><a href="admin_availability.html" > Go back </a></u></center>

</div>

 
          
      
   


  







</body>
</html>