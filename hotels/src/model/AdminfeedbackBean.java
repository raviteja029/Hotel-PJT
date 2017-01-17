package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * Retrieves and returns the Feedback given by the users
 * 
 */
public class AdminfeedbackBean {

	private String feedback;

	/**
	 * 
	 * Retrieves and returns the Feedback given by the users
	 */
	public String returnFeedback() {

		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		String s = "select * from feedback";
		ResultSet rs = c.getRecords(s);
		feedback = "<table cellspacing=10 cellpadding=5><tr><th> NAME </th> <th> CONTACT </th> <th> COMMENTS </th>";
		try {
			while (rs.next()) {
				String name = rs.getString(1);
				String contact = rs.getString(2);
				String comment = rs.getString(3);
				feedback = feedback + "<tr><td>";
				feedback = feedback + name;
				feedback = feedback + "</td><td>";
				feedback = feedback + contact;
				feedback = feedback + "</td><td>";
				feedback = feedback + comment;

				feedback = feedback + "</td></tr>";
			}
			feedback = feedback + "</table>";
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.closeConnection();

		return feedback;

	}

}
