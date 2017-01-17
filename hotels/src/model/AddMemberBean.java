package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMemberBean {
	
	private String name;
	private String mailId;
	private String relation;
	private String admin;

	/**
	 * Sets the values for the data members
	 * @param namex
	 * @param mailIdx
	 * @param relationx
	 * @param adminx
	 * @param passwordx
	 * @param addressx
	 * @param cityx
	 * @param statex
	 * @param countryx
	 */
	public void setAttributes(String namex, String mailIdx, String relationx ) {
		name = namex;
		mailId = mailIdx;
		relation = relationx;
		
		

	}

	/**
	 * checks if the user name already exists
	 * @return
	 */
	public boolean checkEmail() {
		ConnectionDB a = new ConnectionDB();
		a.setConnection();
		String s = "select email from login";
		ResultSet rs = a.getRecords(s);
		boolean flag = true;
		try {
			while (rs.next()) {
				if (mailId.equals(rs.getString(1)))
				{
					flag = false;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * inserts the obtained value to create a new user
	 */
	public void updateTable() {
		ConnectionDB con = new ConnectionDB();
		con.setConnection();
		String s = "insert into user_details values('" + name + "','" + mailId
				+ "','" + relation + "')";
		//String s1 = "insert into login values('" + mailId + "','" + password
			//	+ "')";
		con.updateRecords(s);
		//con.updateRecords(s1);
	}


}
