package com.pod2.OnlineBankingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pod2.OnlineBankingSystem.entities.FeedbackDetails;


/**
 * The Interface FeedbackDao.
 */
public interface FeedbackDao extends JpaRepository<FeedbackDetails, Integer> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<FeedbackDetails> findAll();

	
	
	
	/**
	 * Delete.
	 
	 * @param feedback the feedback
	 */
	public void delete(FeedbackDetails feedback);

	/**
	 * Find by feedback id.
	 *
	 * @param feedbackid the feedbackid
	 * @return the feedback details
	 */
	public FeedbackDetails findByFeedbackId(int feedbackid);

}
