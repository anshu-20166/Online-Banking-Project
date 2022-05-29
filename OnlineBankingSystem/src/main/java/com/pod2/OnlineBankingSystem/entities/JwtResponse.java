package com.pod2.OnlineBankingSystem.entities;

/**
 * The Class JwtResponse.
 */
public class JwtResponse {

	/** The token. */
	String token;

	/**
	 * Instantiates a new jwt response.
	 */
	public JwtResponse() {

	}

	/**
	 * Instantiates a new jwt response.
	 *
	 * @param token the token
	 */
	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

}