package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * Retrieves and returns the Booking information from the Booking Table
 * 
 */
public class AdminbookedBean {

	private String booked;

	/**
	 * 
	 * Retrieves and returns the Booking information from the Booking Table
	 */
	public String returnBooked() {

		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		String s = "select * from bookings";
		ResultSet rs = c.getRecords(s);
		booked = "<table cellspacing=10 cellpadding=5><tr><th> USER </th> <th> ROOMTYPE </th> <th> CHECKIN </th> <th> CHECKOUT </th> <th> DAYS STAYED </th><th> ROOM COST </th><th> EXTRA COST </th><th> TOTAL COST </th><th> TRANSACTION KEY </th>";
		try {
			while (rs.next()) {
				String name = rs.getString(1);
				String type = rs.getString(2);
				String chkin = rs.getString(3);
				String chkout = rs.getString(4);
				int daysstayed = rs.getInt(5);
				int roomcost = rs.getInt(6);
				int extracost = rs.getInt(7);
				int totalcost = rs.getInt(8);
				int transkey = rs.getInt(9);
				booked = booked + "<tr><td>";
				booked = booked + name;
				booked = booked + "</td><td>";
				booked = booked + type;
				booked = booked + "</td><td>";
				booked = booked + chkin;
				booked = booked + "</td><td>";
				booked = booked + chkout;
				booked = booked + "</td><td>";
				booked = booked + daysstayed;
				booked = booked + "</td><td>";
				booked = booked + roomcost;
				booked = booked + "</td><td>";
				booked = booked + extracost;
				booked = booked + "</td><td>";
				booked = booked + totalcost;
				booked = booked + "</td><td>";
				booked = booked + transkey;
				booked = booked + "</td></tr>";

			}
			booked = booked + "</table>";
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();

		return booked;

	}

}
