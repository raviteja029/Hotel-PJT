package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Performs the cost calculations and the difference in date based on the users
 * choice
 * 
 */
public class ConfirmationBean {

	private int extras1;
	private int extras2;
	private int extra_amt;
	private String userName;
	private String roomType;
	private String date1;
	private String date2;
	private int roomCost;
	private int transKey;
	private int totalCost;
	private int daysStayed;
	private String roomChoice;

	/**
	 * Sets the value for the extras chosen - pickup
	 * 
	 * @param e1
	 */
	public void setExtra1(int e1) {
		extras1 = e1;
	}

	/**
	 * Sets the value for the extras chosen - drop
	 * 
	 * @param e2
	 */
	public void setExtra2(int e2) {
		extras2 = e2;
	}

	/**
	 * Sets the cost for the extras chosen
	 * 
	 * @param ea
	 */
	public void setExtraamt(int ea) {
		extra_amt = ea;
	}

	/**
	 * Sets the user name for the member username
	 * 
	 * @param dummy
	 */

	public void setName(String dummy) {
		userName = dummy;
		System.out.print(userName);
	}

	/**
	 * Sets the type of room booked
	 * 
	 * @param rt
	 */

	public void setRoomtype(String rt) {
		roomType = rt;
	}

	/**
	 * Sets the check in date
	 * 
	 * @param d1
	 */

	public void setDate1(String d1)

	{
		date1 = d1;
	}

	/**
	 * Sets the check out date
	 * 
	 * @param d2
	 */
	public void setDate2(String d2)

	{
		date2 = d2;
	}

	/**
	 * Sets the number of days stayed
	 * 
	 * @param d2
	 */

	public void setdaysstayed(int d2)

	{
		daysStayed = d2;
	}

	/**
	 * Sets the transaction key generated
	 * 
	 * @param d2
	 */
	public void settranskey(int d2)

	{
		transKey = d2;
	}

	/**
	 * Sets the total cost for the entire booking
	 * 
	 * @param d2
	 */
	public void setcost(int d2)

	{
		roomCost = d2;
	}

	/**
	 * Calculate the difference between the check in date and the check out date
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public int calculateDate(String d1, String d2) {
		Date date1 = new Date();
		Date date2 = new Date();
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd-MM-yy");

		try {
			date1 = (Date) formatter.parse(d1);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		System.out.println("chkindate is " + date1);

		try {
			date2 = (Date) formatter.parse(d2);
		} catch (ParseException e) {
			// TODO Auto-generoomCostd catch block
			e.printStackTrace();
		}
		System.out.println("chkout date is " + date2);
		daysStayed = date2.getDate() - date1.getDate();
		daysStayed++;

		return daysStayed;
	}
	@SuppressWarnings("deprecation")
	public boolean validateDate(String d1, String d2) {
		int flag = 0;
		Date date1 = new Date();
		Date date2 = new Date();
		Date date3 = new Date();
		DateFormat formatter;
		formatter = new SimpleDateFormat("dd-MM-yy");

		try {
			date1 = (Date) formatter.parse(d1);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		System.out.println("chkindate is " + date1);

		try {
			date2 = (Date) formatter.parse(d2);
		} catch (ParseException e) {
			// TODO Auto-generoomCostd catch block
			e.printStackTrace();
		}
		if (date1.getDate() > date2.getDate()) {
			flag = 1;
		}
		if (date3.getDate() > date1.getDate()
				|| date3.getDate() > date2.getDate()) {
			flag = 1;
		}
		if (flag == 1) {
			return false;
		} else {
			return true;
		}

	}
/**
 * Calculates the cost for the type of room chosen and the number of days stayed
 * @param days
 * @return
 */
	public int calculateCost(int days) {

		if (roomType.equals("1")) {
			roomCost = 2569;
			roomChoice = "eco";
		} else if (roomType.equals("2")) {
			roomCost = 4500;
			roomChoice = "dlx";
		} else if (roomType.equals("3")) {
			roomCost = 6122;
			roomChoice = "club";
		} else {
			roomCost = 7983;
			roomChoice = "suite";
		}

		totalCost = roomCost + extra_amt;
		return roomCost;
	}
/**
 * generates the transaction key
 * @return
 */
	public int generateKey() {

		transKey = (int) (1000 + 9999 * Math.random());
		return transKey;
	}

	/**
	 * Updates the database with the confirmation details
	 */
	public void updateDB() {
		boolean flag = false;
		ConnectionDB c = new ConnectionDB();
		c.setConnection();
		totalCost = roomCost + extra_amt;

		String s = "insert into bookings values('" + userName + "','"
				+ roomType + "','" + date1 + "','" + date2 + "'," + daysStayed
				+ "," + roomCost + "," + extra_amt + "," + totalCost + ","
				+ transKey + ")";
		flag = c.updateRecords(s);

		
		String s1 = "update hotel_available set " + roomType + "=" + roomType
				+ "-1 where day between '" + date1 + "' and '" + date2 + "'";
		if (flag == true) {
			c.updateRecords(s1);
		}
		c.closeConnection();
	}

}
