package com.pod2.OnlineBankingSystem.entities;

/**
 * The Class PinInput.
 */
public class PinInput {

	/** The account number. */
	private long accountNumber;

	/** The username. */
	private String username;

	/**
	 * Instantiates a new pin input.
	 *
	 * @param accountNumber the account number
	 * @param username      the username
	 */
	public PinInput(long accountNumber, String username) {
		super();
		this.accountNumber = accountNumber;
		this.username = username;
	}

	/**
	 * Instantiates a new pin input.
	 */
	public PinInput() {

	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("PinInput [accountNumber=%s, username=%s]", accountNumber, username);
	}

}
