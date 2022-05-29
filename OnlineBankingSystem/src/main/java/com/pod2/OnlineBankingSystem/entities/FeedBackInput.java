package com.pod2.OnlineBankingSystem.entities;

/**
 * The Class FeedBackInput.
 */
public class FeedBackInput {

	/** The username. */
	private String username;

	/** The feedback. */
	private String feedback;

	/** The status. */
	private boolean status;

	/**
	 * Instantiates a new feed back input.
	 */
	public FeedBackInput() {

	}

	/**
	 * Instantiates a new feed back input.
	 *
	 * @param username the username
	 * @param feedback the feedback
	 * @param status   the status
	 */
	public FeedBackInput(String username, String feedback, boolean status) {
		super();

		this.username = username;
		this.feedback = feedback;
		this.status = status;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the feedback.
	 *
	 * @return the feedback
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * Sets the feedback.
	 *
	 * @param feedback the new feedback
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	/**
	 * Checks if is status.
	 *
	 * @return true, if is status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}
