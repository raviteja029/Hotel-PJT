package model;

import java.sql.*;

import java.sql.ResultSet;
/**
 * 
 * Validates user for the user name and the password
 *
 */
public class User_validates {

	private String Username;
	private String Password;

	/**
	 * to get the name of admin
	 * 
	 * 
	 */
	public String getAdminName() {
		return Username;
	}

	/**
	 * to set the name of admin to the variable AdminName
	 * 
	 * @param adminName
	 */
	public void setAdminName(String username) {
		Username = username;
		System.out.println(Username);
	}

	/**
	 * to get the password
	 * 
	 * @return
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * to set the password to the variable Password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		Password = password;
		System.out.println(Password);
	}
/**
 * Authenticates the username and password from the database
 * @return
 */
	public boolean checkAuthentication() {
		

		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		System.out.print("after conn stmt");

		System.out.print(Username + Password);
		String s = "select * from login";
		ResultSet rs = c.getRecords(s);
		boolean flag = false;
		try {
			while (rs.next()) {
				if (Username.equals(rs.getString("uname"))
						&& Password.equals(rs.getString("pwd"))) {
					// System.out.println("correct");
					flag = true;
					break;

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();
		return flag;
	}

}
