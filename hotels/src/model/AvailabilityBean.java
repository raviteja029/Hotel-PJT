package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * checks the availability for the date chosen by the user
 * 
 */
public class AvailabilityBean {
	private String chkIn;
	private String chkOut;
	private String roomSelected;

	/**
	 * Sets the value of the chkIn data member
	 * 
	 * @param chkin
	 */
	public void setChkin(String chkin) {
		chkIn = chkin;
	}

	/**
	 * Sets the value of the chkout data member
	 * 
	 * @param chkout
	 */
	public void setChkout(String chkout) {
		chkOut = chkout;
	}

	/**
	 * Sets the value of the roomsel data member
	 * 
	 * @param roomsel
	 */
	public void setRoomselected(String roomsel) {
		roomSelected = roomsel;
	}

	/**
	 * returns the value of the chkIn data member
	 * 
	 * @param chkIn
	 */
	public String getChekin() {
		return chkIn;
	}

	/**
	 * returns the value of the chkOut data member
	 * 
	 * @param chkOut
	 */
	public String getChkout() {
		return chkOut;
	}

	/**
	 * returns the value of the roomSelecteddata member
	 * 
	 * @param roomSelected
	 */
	public String getRoomselected() {
		return roomSelected;

	}

	/**
	 * Sets the value of the chkIn data member
	 * 
	 * @param chkin
	 */

	public boolean checkAvailability() {
		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		String s = "select day," + roomSelected
				+ " from hotel_available where day between '" + chkIn
				+ "' and '" + chkOut + "'";
		ResultSet rs = c.getRecords(s);
		boolean flag = false;
		try {
			while (rs.next()) {
				// String sel_day=rs.getString(1);
				int avail_status = rs.getInt(roomSelected);
				if (avail_status == 0)
					flag = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();
		return flag;
	}
}
