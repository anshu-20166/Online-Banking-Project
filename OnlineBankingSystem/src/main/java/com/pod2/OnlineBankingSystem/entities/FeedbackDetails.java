package com.pod2.OnlineBankingSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class FeedbackDetails.
 */
@Entity
@Table(name = "Feedback_details")
public class FeedbackDetails {

	/** The feedback id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;

	/** The login details. */
	@OneToOne
	@JoinColumn(name = "login_id")
	private LoginDetails loginDetails;

	/** The feedback. */
	private String feedback;

	/** The status. */
	private boolean status;// 0 for unsolved

	/**
	 * Gets the feedback id.
	 *
	 * @return the feedback id
	 */
	public int getFeedbackId() {
		return feedbackId;
	}

	/**
	 * Sets the feedback id.
	 *
	 * @param feedbackId the new feedback id
	 */
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	/**
	 * Gets the login details.
	 *
	 * @return the login details
	 */
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	/**
	 * Sets the login details.
	 *
	 * @param loginDetails the new login details
	 */
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public boolean getStatus() {
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

	/**
	 * Instantiates a new feedback details.
	 *
	 * @param feedbackId   the feedback id
	 * @param loginDetails the login details
	 * @param feedback     the feedback
	 */
	public FeedbackDetails(int feedbackId, LoginDetails loginDetails, String feedback) {
		super();
		this.feedbackId = feedbackId;
		this.loginDetails = loginDetails;
		this.feedback = feedback;
		this.status = false;
	}

	/**
	 * Instantiates a new feedback details.
	 */
	public FeedbackDetails() {

	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("FeedbackDetails [feedbackId=%s, loginDetails=%s, feedback=%s, status=%s]", feedbackId,
				loginDetails, feedback, status);
	}

}
