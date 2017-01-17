package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * Retrieves and returns the Availability on a specific date as given by the
 * administrator
 * 
 */
public class AdmindateavailBean {

	private String availability;
	private String date;

	/**
	 * Sets the value for the data member date.
	 * 
	 * @param dummy
	 */
	public void setDate(String dummy) {
		date = dummy;

	}

	/**
	 * 
	 * Retrieves and returns the Availability on a specific date as given by the
	 * administrator
	 */

	public String returndateAvailability() {

		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		String s = "select * from hotel_available where day ='" + date + "'";
		ResultSet rs = c.getRecords(s);
		availability = "<table cellspacing=10 cellpadding=5><tr><th> DATE </th> <th> ECONOMY </th> <th> DELUXE </th> <th> CLUB </th> <th> SUITE </th>";
		try {
			while (rs.next()) {
				String day = rs.getString(1);
				int eco = rs.getInt(2);
				int dlx = rs.getInt(3);
				int club = rs.getInt(4);
				int suite = rs.getInt(5);
				availability = availability + "<tr><td>";
				availability = availability + day;
				availability = availability + "</td><td>";
				availability = availability + eco;
				availability = availability + "</td><td>";
				availability = availability + dlx;
				availability = availability + "</td><td>";
				availability = availability + club;
				availability = availability + "</td><td>";
				availability = availability + suite;
				availability = availability + "</td></tr>";
			}

			availability = availability + "</table>";
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();

		return availability;

	}

}
