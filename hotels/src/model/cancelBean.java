package model;

import java.sql.ResultSet;
/**
 * 
 * Cancels a booking made by a user
 *
 */
public class cancelBean {
	private String userName;
	private String transKey;
	private String h1 = null;
	private String h2 = null;
	private String h3 = null;
	private String h4 = null;
	private int h5 = 0;
	private int h6 = 0;
	private int h7 = 0;
	private int h8 = 0;
	private int h9 = 0;
/**
 * Sets the user name value to the userName 
 * @param un
 */
	public void setUsername(String un) {
		userName = un;
	}
	/**
	 * Sets the Transaction key value to the transkey 
	 * @param un
	 */
		
	public void setTranskey(String tk) {
		transKey = tk;
	}
/**
 * Cancels a booked room based on the transaction key
 * @return
 */
	public boolean deleteRecords() {
		int flag = 0;
		ConnectionDB dr = new ConnectionDB();
		dr.setConnection();
		try {
			String s = "select * from bookings where user_id ='" + userName
					+ "' and transaction_key ='" + transKey + "'";
			ResultSet rs = dr.getRecords(s);

			while (rs.next()) {
				h1 = rs.getString(1);
				h2 = rs.getString(2);
				h3 = rs.getString(3);
				h4 = rs.getString(4);
				h5 = rs.getInt(5);
				h6 = rs.getInt(6);
				h7 = rs.getInt(7);
				h8 = rs.getInt(8);
				h9 = rs.getInt(9);
				flag = 1;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		String s2 = "insert into history values('" + h1 + "','" + h2 + "','"
				+ h3 + "','" + h4 + "'," + h5 + "," + h6 + "," + h7 + "," + h8
				+ "," + h9 + ")";
		String s3 = "delete from bookings where user_id ='" + userName
				+ "' and transaction_key ='" + transKey + "'";
		String s4 = "update hotel_available set " + h2 + "=" + h2
				+ "+1 where day between '" + h3 + "' and '" + h4 + "'";
		if (flag > 0) {
			dr.updateRecords(s2);
			dr.updateRecords(s3);
			dr.updateRecords(s4);
			return true;
		} else
			return false;
	}

}
