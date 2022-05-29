package com.pod2.OnlineBankingSystem.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The Class CustomerUserDetails.
 */
@SuppressWarnings("serial")
public class CustomerUserDetails implements UserDetails {

	/** The login details. */
	private LoginDetails loginDetails;

	/**
	 * Instantiates a new customer user details.
	 *
	 * @param loginDetails the login details
	 */
	public CustomerUserDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub

		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("user");

		return List.of(simpleGrantedAuthority);
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return loginDetails.getPassword();
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return loginDetails.getUserName();
	}

	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return loginDetails.isLoggedIn();
	}

}
