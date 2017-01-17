package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * defines a method to return room availability information from the database
 * 
 * 
 */
public class AdminavailBean {

	private String availability;

	/**
	 * returns room availability information from the database
	 * 
	 */
	public String returnAvailability() {

		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		String s = "select * from hotel_available";
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
			c.closeConnection();
		}
		c.closeConnection();

		return availability;

	}

}
