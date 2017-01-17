package model;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * Validates the login for the administrator
 *
 */
public class AdminvalidateBean {
	private String adminName;
	private String password;
	
	
	
	public void setAdminName(String username) {
		adminName = username;
		System.out.println(adminName);
	}
	/**
	 * to get the password
	 * @return
	 */
	
	/**
	 * to set the password to the variable Password
	 * @param password
	 */
	public void setPassword(String pwd) {
		password = pwd;
		System.out.println(password);
	}
	
	
	public boolean checkAuthentication(){
		
		
		ConnectionDB c=new ConnectionDB();
		c.setConnection();
		
		
		
		String s="select * from login";
		ResultSet rs=c.getRecords(s);
		boolean flag=false;
		try {
			while(rs.next())
			{
				if(adminName.equals(rs.getString("uname")) &&
						password.equals(rs.getString("pwd")))
				{
					//System.out.println("correct"); 
					flag=true;
					break;
					
					
				}
				
			}
		} catch (SQLException e)
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		c.closeConnection();
		return flag;
	}


}
