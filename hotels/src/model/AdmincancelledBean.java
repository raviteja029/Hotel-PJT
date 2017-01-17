package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * Retrieves and returns the Canceled information from the history Table
 * 
 */
public class AdmincancelledBean {

	private String cancelled;

	/**
	 * Retrieves and returns the Canceled information from the history Table
	 */
	public String returnCancelled() {

		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		String s = "select * from history";
		ResultSet rs = c.getRecords(s);
		cancelled = "<table cellspacing=10 cellpadding=5><tr><th> USER </th> <th> ROOMTYPE </th> <th> CHECKIN </th> <th> CHECKOUT </th> <th> DAYS STAYED </th><th> ROOM COST </th><th> EXTRA COST </th><th> TOTAL COST </th><th> TRANSACTION KEY </th>";
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
				cancelled = cancelled + "<tr><td>";
				cancelled = cancelled + name;
				cancelled = cancelled + "</td><td>";
				cancelled = cancelled + type;
				cancelled = cancelled + "</td><td>";
				cancelled = cancelled + chkin;
				cancelled = cancelled + "</td><td>";
				cancelled = cancelled + chkout;
				cancelled = cancelled + "</td><td>";
				cancelled = cancelled + daysstayed;
				cancelled = cancelled + "</td><td>";
				cancelled = cancelled + roomcost;
				cancelled = cancelled + "</td><td>";
				cancelled = cancelled + extracost;
				cancelled = cancelled + "</td><td>";
				cancelled = cancelled + totalcost;
				cancelled = cancelled + "</td><td>";
				cancelled = cancelled + transkey;
				cancelled = cancelled + "</td></tr>";

			}
			cancelled = cancelled + "</table>";
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();

		return cancelled;

	}

}
