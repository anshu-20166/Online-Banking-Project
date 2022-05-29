package com.pod2.OnlineBankingSystem.entities;

/**
 * The Class RegisterInput.
 */
public class RegisterInput {

	/** The account no. */
	private Long accountNo;

	/** The user name. */
	private String userName;

	/** The password. */
	private String password;

	/**
	 * Gets the account no.
	 *
	 * @return the account no
	 */
	public Long getAccountNo() {
		return accountNo;
	}

	/**
	 * Sets the account no.
	 *
	 * @param accountNo the new account no
	 */
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
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
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "RegisterInput [accountNo=" + accountNo + ", userName=" + userName + ", password=" + password + "]";
	}

}
