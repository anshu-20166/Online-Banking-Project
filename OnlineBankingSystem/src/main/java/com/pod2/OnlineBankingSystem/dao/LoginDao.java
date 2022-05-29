package com.pod2.OnlineBankingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pod2.OnlineBankingSystem.entities.LoginDetails;

/**
 * The Interface LoginDao.
 */
public interface LoginDao extends JpaRepository<LoginDetails, String> {

	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the login details
	 */
	public LoginDetails findByUserName(String userName);
	

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<LoginDetails> findAll();

	/**
	 * Delete.
	 *
	 * @param logindetails the logindetails
	 */
	public void delete(LoginDetails logindetails);

}
