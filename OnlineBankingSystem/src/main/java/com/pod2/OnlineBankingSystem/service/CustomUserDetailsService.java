package com.pod2.OnlineBankingSystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pod2.OnlineBankingSystem.dao.FeedbackDao;
import com.pod2.OnlineBankingSystem.dao.LoginDao;
import com.pod2.OnlineBankingSystem.dao.UserDao;
import com.pod2.OnlineBankingSystem.entities.CustomerUserDetails;
import com.pod2.OnlineBankingSystem.entities.FeedBackInput;
import com.pod2.OnlineBankingSystem.entities.FeedbackDetails;
import com.pod2.OnlineBankingSystem.entities.FundInput;
import com.pod2.OnlineBankingSystem.entities.LoginDetails;
import com.pod2.OnlineBankingSystem.entities.PinInput;
import com.pod2.OnlineBankingSystem.entities.RegisterInput;
import com.pod2.OnlineBankingSystem.entities.Users;
import com.pod2.OnlineBankingSystem.utility.GlobalResources;

/**
 * The Class CustomUserDetailsService.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	/** The logindao. */
	@Autowired
	private LoginDao logindao;

	/** The userdao. */
	@Autowired
	private UserDao userdao;

	/** The feedbackdao. */
	@Autowired
	private FeedbackDao feedbackdao;

	/** The logger. */
	private Logger logger = GlobalResources.getLogger(CustomUserDetailsService.class);

	/**
	 * Load user by username.
	 *
	 * @param userName the user name
	 * @return the user details
	 * @throws UsernameNotFoundException the username not found exception
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		String methodName = "SERVICE LoadUser()";
		logger.info(methodName + "CALLED");
		final LoginDetails user = this.logindao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		} else {

			user.setLoggedIn(true);
			logindao.save(user);
			return new CustomerUserDetails(user);
		}
	}

	/**
	 * Close account.
	 *
	 * @param userName the user name
	 * @return true, if successful
	 */
	public boolean closeAccount(String userName) {
		String methodName = "closeAccount()";
		logger.info(methodName + "CALLED");
		final LoginDetails loginDetails = this.logindao.findByUserName(userName);
		Users users = userdao.findByaccountNumber(loginDetails.getUserDetails().getAccountNumber());
		users.setCloseAccount(1);
		userdao.save(users);
		return true;
	}
	/**
	 * get Close account status.
	 *
	 * @param userName the user name
	 * @return int 
	 */
	public int closeAccountStatus(String userName) {
		String methodName = "closeAccountStatus()";
		logger.info(methodName + "CALLED");
		final LoginDetails loginDetails = this.logindao.findByUserName(userName);
		Users users = userdao.findByaccountNumber(loginDetails.getUserDetails().getAccountNumber());
		int status=users.getCloseAccount();
		
		return status;
	}
	/**
	 * Delete account.
	 *
	 * @param accountNumber the account number
	 * @return true, if successful
	 */
	public boolean deleteAccount(long accountNumber) {
		String methodName = "DeleteAccount()";
		logger.info(methodName + "CALLED");
		List<LoginDetails> logindetails = this.logindao.findAll();
		Users user = userdao.findByaccountNumber(accountNumber);
		LoginDetails loginUser = new LoginDetails();
		for (LoginDetails login : logindetails) {
			if (login.getUserDetails().getAccountNumber() == accountNumber) {
				loginUser = login;
			}
		}
	int id = loginUser.getLoginId();
	
	List<FeedbackDetails>Feedbackdetails = this.feedbackdao.findAll();
	FeedbackDetails feedback=new FeedbackDetails();
	for(int i=0;i<Feedbackdetails.size();i++)
	{
		if(Feedbackdetails.get(i).getLoginDetails().getLoginId()==id)
		{
			feedback=Feedbackdetails.get(i);
			feedbackdao.delete(feedback);
			
		}
	}
	System.out.println("FEEDBACK");

	    //feedbackdao.delete(feedback);
		logindao.delete(loginUser);
		this.userdao.delete(user);
	
		return true;
	}

	/**
	 * Change feedback status.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean changeFeedbackStatus(int id) {
		String methodName = "changeFeedBAckStatus()";
		logger.info(methodName + "CALLED");
		FeedbackDetails feedback = this.feedbackdao.findByFeedbackId(id);
		boolean b = feedback.getStatus();
		feedback.setStatus(!b);
		feedbackdao.save(feedback);
		return !b;
	}

	/**
	 * Creates the user.
	 *
	 * @param registerInput the register input
	 * @return the int
	 */
	public int createUser(RegisterInput registerInput) {

		String methodName = "createUser()";
		logger.info(methodName + "CALLED");

		LoginDetails user = this.logindao.findByUserName(registerInput.getUserName());
		
		List<LoginDetails> user1=this.logindao.findAll();
		for(int i=0;i<user1.size();i++)
		{
			if(user1.get(i).getUserDetails().getAccountNumber().equals(registerInput.getAccountNo()))
			{
				return 3;
			}
		}
		System.out.println(user);
		if (user != null) {
			return 1;
		} 
		
		else {
			final Users bankuser = this.userdao.findByaccountNumber(registerInput.getAccountNo());

			if (bankuser == null) {
				return 0;
			} else {
				// System.out.println(user.getClass());
				LoginDetails user2 = new LoginDetails();
				user2.setUserName(registerInput.getUserName());
				user2.setPassword(registerInput.getPassword());
				user2.setLoggedIn(true);
				user2.setUserDetails(bankuser);

				logindao.save(user2);
				return 2;
			}
		}
	}

	/**
	 * Adds the new user.
	 *
	 * @param newUser the new user
	 * @return the int
	 */
	public int AddNewUser(Users newUser) {
		String methodName = "AddNewUser()";
		logger.info(methodName + "CALLED");
		userdao.save(newUser);
		return 1;
	}

	/**
	 * Balance check.
	 *
	 * @param username the username
	 * @return the float
	 */
	public float balanceCheck(String username) {
		String methodName = "balanceCheck()";
		logger.info(methodName + "CALLED");
		LoginDetails loginDetails = logindao.findByUserName(username);
		Users users = userdao.findByaccountNumber(loginDetails.getUserDetails().getAccountNumber());
		return users.getBalance();
	}

	/**
	 * Account view.
	 *
	 * @param username the username
	 * @return the users
	 */
	public Users accountView(String username) {
		String methodName = " Service accountView()";
		logger.info(methodName + "CALLED");
		LoginDetails loginDetails = logindao.findByUserName(username);
		Users users = userdao.findByaccountNumber(loginDetails.getUserDetails().getAccountNumber());
		return users;
	}

	/**
	 * Adds the feedback.
	 *
	 * @param feedBackInput the feed back input
	 * @return the int
	 */
	public int addFeedback(FeedBackInput feedBackInput) {
		String methodName = "  addFeedback()";
		logger.info(methodName + "CALLED");

		LoginDetails loginDetails = logindao.findByUserName(feedBackInput.getUsername());

		FeedbackDetails details = new FeedbackDetails();
		details.setLoginDetails(loginDetails);
		details.setFeedback(feedBackInput.getFeedback());
		details.setStatus(false);
		feedbackdao.save(details);

		return 1;
	}

	/**
	 * View feed back.
	 *
	 * @param username the username
	 * @return the list
	 */
	public List<FeedbackDetails> viewFeedBack(String username) {
		String methodName = "  viewFeedBack()";
		logger.info(methodName + "CALLED");
		List<FeedbackDetails> details = this.feedbackdao.findAll();

		return details;

	}

	/**
	 * Show atm pin.
	 *
	 * @param pinInput the pin input
	 * @return the int
	 */
	public int showAtmPin(PinInput pinInput) {
		String methodName = "  showAtmPin()";
		logger.info(methodName + "CALLED");
		LoginDetails loginDetails = logindao.findByUserName(pinInput.getUsername());
		Users user = userdao.findByaccountNumber(loginDetails.getUserDetails().getAccountNumber());
		if (user.getAccountNumber() == pinInput.getAccountNumber()) {
			// return "Your ATM PIN is " + user.getAtmPin();
			return user.getAtmPin();
		} else {
			return 0;
		}

	}

	/**
	 * Fundtransfer.
	 *
	 * @param fundInput the fund input
	 * @return the float
	 */
//	public float fundtransfer(FundInput fundInput) {
//
//		String methodName = "FundTransfer()";
//		logger.info(methodName + "CALLED");
//		long account1 = fundInput.getAccountNumber1();
//		long account2 = fundInput.getAccountNumber2();
//		Users users1 = userdao.findByaccountNumber(account1);
//		Users users2 = userdao.findByaccountNumber(account2);
//		LoginDetails loginDetails = logindao.findByUserName(fundInput.getUsername());
//		Users user = userdao.findByaccountNumber(loginDetails.getUserDetails().getAccountNumber());
//		if (users1 == null || users2 == null || user.getAccountNumber() != fundInput.getAccountNumber1()) {
//			
//			// return "Enter valid account Number";
//			return 0;
//
//		} else {
//			if (fundInput.getAmount() >= users1.getBalance()) {
//				// return "Amount exceeded from your current balance";
//				return -1;
//			} else {
//
//				float amount1 = users1.getBalance() - fundInput.getAmount();
//				float amount2 = users2.getBalance() + fundInput.getAmount();
//				users1.setBalance(amount1);
//				users2.setBalance(amount2);
//				userdao.save(users1);
//				userdao.save(users2);
//				System.out.println(users1.getBalance());
//				System.out.println(users2.getBalance());
//				// return "Amount has been successfully transfered";
//				return (users1.getBalance());
//			}
//
//		}
//	}
	public float fundtransfer(FundInput fundInput) {

		String methodName = "FundTransfer()";
		logger.info(methodName + "CALLED");
		long account1 = fundInput.getAccountNumber1();
		long account2 = fundInput.getAccountNumber2();
		Users users1 = userdao.findByaccountNumber(account1);
		Users users2 = userdao.findByaccountNumber(account2);
		if (users1 == null || users2 == null) {
			// return "Enter valid account Number";
			return 0;

		} else {
			if (fundInput.getAmount() >= users1.getBalance()) {
				// return "Amount exceeded from your current balance";
				return -1;
			} else {

				float amount1 = users1.getBalance() - fundInput.getAmount();
				float amount2 = users2.getBalance() + fundInput.getAmount();
				users1.setBalance(amount1);
				users2.setBalance(amount2);
				userdao.save(users1);
				userdao.save(users2);
				System.out.println(users1.getBalance());
				System.out.println(users2.getBalance());
				// return "Amount has been successfully transfered";
				return (users1.getBalance());
			}

		}
	}

	/**
	 * Logout.
	 *
	 * @param username the username
	 */
	public void logout(String username) {
		String methodName = "  logout()";
		logger.info(methodName + "CALLED");
		LoginDetails loginDetails = logindao.findByUserName(username);
		loginDetails.setLoggedIn(false);

	}

}