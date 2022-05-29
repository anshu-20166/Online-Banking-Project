package com.pod2.OnlineBankingSystem.entities;

/**
 * The Class FundInput.
 */
public class FundInput {

	/** The account number 1. */
	private long accountNumber1;

	/** The account number 2. */
	private long accountNumber2;

	/** The amount. */
	private float amount;
	private String username;

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public float getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}

	/**
	 * Instantiates a new fund input.
	 */
	public FundInput() {

	}

	/**
	 * Instantiates a new fund input.
	 *
	 * @param accountNumber1 the account number 1
	 * @param accountNumber2 the account number 2
	 * @param amount         the amount
	 */
	public FundInput(long accountNumber1, long accountNumber2, float amount,String username) {
		super();
		this.accountNumber1 = accountNumber1;
		this.accountNumber2 = accountNumber2;
		this.amount = amount;
		this.username = username;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format("FundInput [accountNumber1=%s, accountNumber2=%s, amount=%s ,username=%s]", accountNumber1,
				accountNumber2, amount,username);
	}

	/**
	 * Gets the account number 1.
	 *
	 * @return the account number 1
	 */
	public long getAccountNumber1() {
		return accountNumber1;
	}

	/**
	 * Sets the account number 1.
	 *
	 * @param accountNumber1 the new account number 1
	 */
	public void setAccountNumber1(long accountNumber1) {
		this.accountNumber1 = accountNumber1;
	}

	/**
	 * Gets the account number 2.
	 *
	 * @return the account number 2
	 */
	public long getAccountNumber2() {
		return accountNumber2;
	}

	/**
	 * Sets the account number 2.
	 *
	 * @param accountNumber2 the new account number 2
	 */
	public void setAccountNumber2(long accountNumber2) {
		this.accountNumber2 = accountNumber2;
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
}