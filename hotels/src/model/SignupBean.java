package model;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 *Creates a new user
 *
 */
public class SignupBean {

	private String user_name;
	private String mailId;
	private String mobile;
	private String aadharID;
	private String password;
	private String address;
	private String city;
	private String state;
	private String country;

	/**
	 * Sets the values for the data members
	 * @param namex
	 * @param mailIdx
	 * @param mobilex
	 * @param userNamex
	 * @param passwordx
	 * @param addressx
	 * @param cityx
	 * @param statex
	 * @param countryx
	 */
	public void setAttributes(String namex, String mailIdx, String mobilex,
			String aadharIDx, String passwordx, String addressx, String cityx,
			String statex, String countryx) {
		user_name = namex;
		mailId = mailIdx;
		mobile = mobilex;
		aadharID = aadharIDx;
		password = passwordx;
		address = addressx;
		city = cityx;
		state = statex;
		country = countryx;

	}

	/**
	 * checks if the user name already exists
	 * @return
	 */
	public boolean checkEmail() {
		
		boolean flag = true;
			
			Connection con = null;
	    	try{
	           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          
	           con = DriverManager.getConnection("jdbc:odbc:dbtest");
	           System.out.println("connected");
	           Statement st=con.createStatement();
	              
	           String s1 = "select * from login";
	         
	           ResultSet rs = st.executeQuery(s1);
	        		 
	          while(rs.next()){
	        	  if(mailId.equals(rs.getString(1)));
	              flag = false;
	          }
	           rs.close();
	           st.close();
	           con.close();
	           System.out.println("selected statements");
	           
	          
	       	          
	              
	        
	         
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * inserts the obtained value to create a new user
	 */
	public void updateTable() {
		
		
		Connection con = null;
    	try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          
           
           con = DriverManager.getConnection("jdbc:odbc:dbtest");
           System.out.println("connected");
           Statement st=con.createStatement();
           
           String s = "insert into user_details values('" + user_name + "','" + mailId
   				+ "','" + mobile + "','" + aadharID + "','" + password + "','"
   				+ address + "','" + city + "','" + state + "','" + country
   				+ "')";
   		String s1 = "insert into login values('" + mailId + "','" + password
   				+ "')";
           
           st.executeUpdate(s);
           st.executeUpdate(s1);
           st.close();
           con.close();
           System.out.println("Row is added");
           
    	}
    	
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
