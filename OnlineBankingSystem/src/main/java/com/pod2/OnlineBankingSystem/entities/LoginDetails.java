package com.pod2.OnlineBankingSystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * The Class LoginDetails.
 */
@Entity
@Table(name = "Login_details")
public class LoginDetails {

	/** The login id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loginId;

	/** The user name. */
	@Size(min = 6, message = "minimum of 6 length is required")
	private String userName;

	/** The password. */
	@Size(min = 6, message = "minimum of 6 length is required")
	private String password;

	/** The user details. */
	@OneToOne
	@JoinColumn(name = "account_number")
	private Users userDetails;

	/** The logged in. */
	private boolean loggedIn;

	/**
	 * Instantiates a new login details.
	 */
	// constructor
	public LoginDetails() {
	}

	/**
	 * Instantiates a new login details.
	 *
	 * @param userName the user name
	 * @param password the password
	 */
	public LoginDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;

	}

	// getter and setter

	/**
	 * Gets the login id.
	 *
	 * @return the login id
	 */
	public int getLoginId() {
		return loginId;
	}

	/**
	 * Sets the login id.
	 *
	 * @param loginId the new login id
	 */
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user details.
	 *
	 * @return the user details
	 */
	public Users getUserDetails() {
		return userDetails;
	}

	/**
	 * Sets the user details.
	 *
	 * @param userDetails the new user details
	 */
	public void setUserDetails(Users userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * Checks if is logged in.
	 *
	 * @return true, if is logged in
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Sets the logged in.
	 *
	 * @param loggedIn the new logged in
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDetails other = (LoginDetails) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("LoginDetails [userName=%s, password=%s, userDetails=%s, loggedIn=%s]", userName, password,
				userDetails, loggedIn);
	}

}
