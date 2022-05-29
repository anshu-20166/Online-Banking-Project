package com.pod2.OnlineBankingSystem.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Users.
 */
@Entity
@Table(name = "users_details")
public class Users {

	/** The account number. */
	@Id
	private Long accountNumber;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The type of aaccount. */
	private String typeOfAaccount;

	/** The phone number. */
	private long phoneNumber;

	/** The atm pin. */
	private int atmPin;

	/** The balance. */
	private float balance;

	/** The d OB. */
	private Date dOB;

	/** The home branch. */
	private String homeBranch;

	/** The date of opening. */
	private Date dateOfOpening;

	/** The close account. */
	private int closeAccount = 0;

	/**
	 * Instantiates a new users.
	 */
	// constructor
	public Users() {

	}

	/**
	 * Instantiates a new users.
	 *
	 * @param accountNumber  the account number
	 * @param firstName      the first name
	 * @param lastName       the last name
	 * @param typeOfAaccount the type of aaccount
	 * @param phoneNumber    the phone number
	 * @param atmPin         the atm pin
	 * @param balance        the balance
	 * @param dOB            the d OB
	 * @param homeBranch     the home branch
	 * @param dateOfOpening  the date of opening
	 * @param closeAccount   the close account
	 */
	public Users(Long accountNumber, String firstName, String lastName, String typeOfAaccount, long phoneNumber,
			int atmPin, float balance, Date dOB, String homeBranch, Date dateOfOpening, int closeAccount) {
		super();
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.typeOfAaccount = typeOfAaccount;
		this.phoneNumber = phoneNumber;
		this.atmPin = atmPin;
		this.balance = balance;
		this.dOB = dOB;
		this.homeBranch = homeBranch;
		this.dateOfOpening = dateOfOpening;
		this.closeAccount = closeAccount;
	}

	/**
	 * Gets the close account.
	 *
	 * @return the close account
	 */
	public int getCloseAccount() {
		return closeAccount;
	}

	/**
	 * Sets the close account.
	 *
	 * @param closeAccount the new close account
	 */
	public void setCloseAccount(int closeAccount) {
		this.closeAccount = closeAccount;
	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	// getter and setter
	public Long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the type of aaccount.
	 *
	 * @return the type of aaccount
	 */
	public String getTypeOfAaccount() {
		return typeOfAaccount;
	}

	/**
	 * Sets the type of aaccount.
	 *
	 * @param typeOfAaccount the new type of aaccount
	 */
	public void setTypeOfAaccount(String typeOfAaccount) {
		this.typeOfAaccount = typeOfAaccount;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the atm pin.
	 *
	 * @return the atm pin
	 */
	public int getAtmPin() {
		return atmPin;
	}

	/**
	 * Sets the atm pin.
	 *
	 * @param atmPin the new atm pin
	 */
	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}

	/**
	 * Gets the balance.
	 *
	 * @return the balance
	 */
	public float getBalance() {
		return balance;
	}

	/**
	 * Sets the balance.
	 *
	 * @param balance the new balance
	 */
	public void setBalance(float balance) {
		this.balance = balance;
	}

	/**
	 * Gets the d OB.
	 *
	 * @return the d OB
	 */
	public Date getdOB() {
		return dOB;
	}

	/**
	 * Sets the d OB.
	 *
	 * @param dOB the new d OB
	 */
	public void setdOB(Date dOB) {
		this.dOB = dOB;
	}

	/**
	 * Gets the home branch.
	 *
	 * @return the home branch
	 */
	public String getHomeBranch() {
		return homeBranch;
	}

	/**
	 * Sets the home branch.
	 *
	 * @param homeBranch the new home branch
	 */
	public void setHomeBranch(String homeBranch) {
		this.homeBranch = homeBranch;
	}

	/**
	 * Gets the date of opening.
	 *
	 * @return the date of opening
	 */
	public Date getDateOfOpening() {
		return dateOfOpening;
	}

	/**
	 * Sets the date of opening.
	 *
	 * @param dateOfOpening the new date of opening
	 */
	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return String.format(
				"Users [accountNumber=%s, firstName=%s, lastName=%s, typeOfAaccount=%s, phoneNumber=%s, atmPin=%s, balance=%s, dOB=%s, homeBranch=%s, dateOfOpening=%s]",
				accountNumber, firstName, lastName, typeOfAaccount, phoneNumber, atmPin, balance, dOB, homeBranch,
				dateOfOpening);
	}

}