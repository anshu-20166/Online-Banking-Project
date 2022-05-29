package com.pod2.OnlineBankingSystem.entities;

/**
 * The Class JwtModel.
 */
public class JwtModel {

	/** The username. */
	String username;

	/** The password. */
	String password;

	/**
	 * Instantiates a new jwt model.
	 */
	public JwtModel() {

	}

	/**
	 * Instantiates a new jwt model.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public JwtModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("JwtModel [userName=%s, password=%s]", username, password);
	}
}
