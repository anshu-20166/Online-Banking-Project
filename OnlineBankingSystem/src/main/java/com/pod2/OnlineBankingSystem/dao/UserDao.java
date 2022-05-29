package com.pod2.OnlineBankingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pod2.OnlineBankingSystem.entities.Users;

/**
 * The Interface UserDao.
 */
public interface UserDao extends JpaRepository<Users, String> {

	/**
	 * Find byaccount number.
	 *
	 * @param accountNo the account no
	 * @return the users
	 */
	public Users findByaccountNumber(Long accountNo);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Users> findAll();

}
