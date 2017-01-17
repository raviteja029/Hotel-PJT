<html>
<head>
   
   <meta http-equiv="Content-Type" content="text/html;">
   <script language="javaScript" type="text/javascript" >
if (window.attachEvent) window.attachEvent("onload", sfHover);

</script>
   

<link href="calendar.css" rel="stylesheet" type="text/css">
</head>
<body id="main">
<img id="im" src="images/Royal_Castle_29267.gif" />

 <%
 HttpSession ses =request.getSession(true);
 %>
<div id="two">
		<font size="5" face="Monotype Corsiva"><center><b>RESERVATION CONFIRMATION</b></center></font><br><br>
	
		<center>
		<table cellspacing=10 cellpadding=5>
		<tr>
		<td><b>BOOKING ID</b></td>
		<td></td>
		<td><b> <%=ses.getAttribute("transKey")%></b></td>
		</tr>
		<tr>
		<td>USERNAME</td>
		<td></td>
		<td><%=ses.getAttribute("username")%></td>
		</tr>
		<tr>
		<td>ROOM TYPE</td>
		<td></td>
		<td><%=ses.getAttribute("roomType")%></td>
		</tr>
		<tr>
		<td>CHECK-IN DATE</td>
		<td></td>
		<td><%=ses.getAttribute("date1")%></td>
		</tr>
		<tr>
		<td>CHECK-OUT DATE</td>
		<td></td>
		<td><%=ses.getAttribute("date2")%></td>
		</tr>
		<tr>
		<td>DAYS STAYED</td>
		<td></td>
		<td><%=ses.getAttribute("diff")%></td>
		</tr>
		<tr>
		<td>ROOM COST</td>
		<td></td>
		<td><%=ses.getAttribute("cost")%>(INR)</td>
		</tr>
		<tr>
		<td>EXTRAS COST</td>
		<td></td>
		<td><%=ses.getAttribute("extra_amt")%>(INR)</td>
		</tr>
		<tr>
		<td>TOTAL COST</td>
		<td></td>
		<td>
		<%int i1 =(Integer) ses.getAttribute("extra_amt");
		int i2 = (Integer)ses.getAttribute("cost");
		int i3 = (Integer)ses.getAttribute("diff"); 
		int i4 = ((i2*i3)+i1);
		out.println(i4);%>(INR)</td>
		</tr>
		</table>
		</center>
	<br><br>
	<center><input type="button" value="Print this page" onClick="window.print()"></center>
	
	
	<center>
	<form action="FinalServlet" method="post">
          <input type="submit" value="Confirm"><br>
    </form>
    <form action="calendar.html">
           <input type="Submit" value="Cancel">
    </form>
	</center>
	
	

	
	

</div>



  </body>
</html>