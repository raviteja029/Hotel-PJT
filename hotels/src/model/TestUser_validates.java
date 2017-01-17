package model;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestUser_validates {
	
	private String Username;
	private String Password;
	
	/**
	 * to set the name of admin to the variable AdminName
	 * @param adminName
	 */
	
	public void testsetAdminName(String username) {
		Username = username;
		System.out.println(Username);
	}
	/**
	 * to get the password
	 * @return
	 */
	
	/**
	 * to set the password to the variable Password
	 * @param password
	 */
	public void testsetPassword(String password) {
		Password = password;
		System.out.println(Password);
	}
	
	@Test
	public void testCheckAuthentication(){
		
		User_validates uv = new User_validates();
		String inputName="nithi";
		String inputPwd="nithi";
			uv.setAdminName(inputName);
		uv.setPassword(inputPwd);
				
		assertEquals(true,uv.checkAuthentication());
	}


}
