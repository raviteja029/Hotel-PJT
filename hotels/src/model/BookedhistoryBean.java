package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * Returns the booked history of the currently logged in user
 * 
 */
public class BookedhistoryBean {

	private String bookedhistory;
	private String userName;

	/**
	 * Sets the value of the user name to un
	 * 
	 * @param un
	 */
	public void setUsername(String un) {
		userName = un;
	}

	/**
	 * Returns the bookings details specific to the currently logged in user.
	 * 
	 * @return
	 */
	public String returnbookedhistory() {

		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		String s = "select * from bookings where user_id='" + userName + "'";
		ResultSet rs = c.getRecords(s);
		bookedhistory = "<table cellspacing=10 cellpadding=5><tr><th> USER </th> <th> ROOMTYPE </th> <th> CHECKIN </th> <th> CHECKOUT </th> <th> DAYS STAYED </th><th> ROOM COST </th><th> EXTRA COST </th><th> TOTAL COST </th><th> BOOKING ID</th>";
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
				bookedhistory = bookedhistory + "<tr><td>";
				bookedhistory = bookedhistory + name;
				bookedhistory = bookedhistory + "</td><td>";
				bookedhistory = bookedhistory + type;
				bookedhistory = bookedhistory + "</td><td>";
				bookedhistory = bookedhistory + chkin;
				bookedhistory = bookedhistory + "</td><td>";
				bookedhistory = bookedhistory + chkout;
				bookedhistory = bookedhistory + "</td><td>";
				bookedhistory = bookedhistory + daysstayed;
				bookedhistory = bookedhistory + "</td><td>";
				bookedhistory = bookedhistory + roomcost;
				bookedhistory = bookedhistory + "</td><td>";
				bookedhistory = bookedhistory + extracost;
				bookedhistory = bookedhistory + "</td><td>";
				bookedhistory = bookedhistory + totalcost;
				bookedhistory = bookedhistory + "</td><td>";
				bookedhistory = bookedhistory + transkey;
				bookedhistory = bookedhistory + "</td></tr>";
			}
			bookedhistory = bookedhistory + "</table>";
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();

		return bookedhistory;

	}

}
