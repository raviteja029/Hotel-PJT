package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class SendAP {
	private String usrName;
	private String toAddress;
	private int transactionKey,extraCost,roomCost,totalCost;
	private String chkin=null,chkout=null;
	public void setName(String name)
	{
		name=usrName;
	}
	public void setAttributes(int transKey,String date1,String date2,int cost,int extra_amt,int diff)
	{
		transactionKey=transKey;
		chkin=date1;
		chkout=date2;
		roomCost=cost;
		extraCost=extra_amt;
		totalCost=(diff*cost)+extraCost;
		

	}

public static void send(String smtpHost, int smtpPort,
String from1, String to1,
String subject, String content)
{
try{
Properties props = new Properties( );
props.put("mail.smtps.host", "smtp.mail.yahoo.com");
props.put("mail.smtps.auth", "true");
final Session session = Session.getInstance(props);
Session mailConnection = Session.getInstance(props, null);
final Message msg = new MimeMessage(mailConnection);
Address to = new InternetAddress(to1);
Address from = new InternetAddress(from1);
msg.setContent(content, "text/plain");
msg.setFrom(from);
msg.setRecipient(Message.RecipientType.TO, to);
msg.setSubject(subject);

Transport tr = session.getTransport("smtps");
System.out.println("inside tr");
tr.connect("smtp.mail.yahoo.com","contact_royalcastle@yahoo.com","goldenbatch");
tr.sendMessage(msg, msg.getAllRecipients());
tr.close();

}
catch (Exception ex) {
ex.printStackTrace( );

}
}
public void getMailID()
{
	ConnectionDB cd=new ConnectionDB();
	cd.setConnection();
	
	ResultSet rs= cd.getRecords("select mailid from user_details where name='"+usrName+"'");

	try {
		System.out.println(rs.getString(2));
		toAddress=rs.getString(2);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		send("smtp.mail.yahoo.com",25,"contact_royalcastle@yahoo.com",toAddress,
				"CONFIRMATION FROM ROYALCASTLE!!!","Hai Thanks For Your Booking @ RoyalCastle \n\n UserName:\t '"+usrName+"'\n\n Transaction ID:\t "+transactionKey+"\n\n Check In:\t '"+chkin+"'\n\n Check Out:\t '"+chkout+"'\n\n RoomCost:\t "+roomCost+"\n\n Extra Cost:\t "+extraCost+" \n\n Total Cost:\t "+totalCost+"\n\n Have A Happy Stay " );
	
}


/*public static void main(String[] args) throws Exception {
// Send a test message
send("smtp.mail.yahoo.com",25,"frmaddress@yahoo.com","toaddress@gmail.com",
"Hello", "Hello, \n\n How are you ?");*/
}
