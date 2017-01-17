package model;

/**
 * Inserts the feed back details given by the user
 * 
 */
public class FeedbackBean {

	private String userName;
	private String userComment;
	private String userContact;

	/**
	 * sets the value for the username
	 * 
	 * @param un
	 */
	public void setUname(String un) {
		userName = un;
		System.out.println(userName);
	}

	/**
	 * Sets the value for the comment
	 * 
	 * @param cmnt
	 */
	public void setComment(String cmnt) {
		userComment = cmnt;
	}

	/**
	 * Sets the contact information
	 * 
	 * @param cont
	 */
	public void setContact(String cont) {
		userContact = cont;
	}

	/**
	 * Inserts the user feedback into the database
	 * 
	 * @return
	 */

	public boolean updateFeedback() {
		if (userName.equals("") || userComment.equals("")) {
			System.out.println("inside false");
			return false;
		} else {
			ConnectionDB cd = new ConnectionDB();
			cd.setConnection();
			String s = "insert into feedback values('" + userName + "','"
					+ userContact + "','" + userComment + "')";
			cd.updateRecords(s);
			return true;
		}

	}

}
