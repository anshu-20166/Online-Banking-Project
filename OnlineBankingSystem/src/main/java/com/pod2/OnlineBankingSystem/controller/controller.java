package com.pod2.OnlineBankingSystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pod2.OnlineBankingSystem.dao.FeedbackDao;
import com.pod2.OnlineBankingSystem.dao.LoginDao;
import com.pod2.OnlineBankingSystem.dao.UserDao;
import com.pod2.OnlineBankingSystem.entities.FeedBackInput;
import com.pod2.OnlineBankingSystem.entities.FeedbackDetails;
import com.pod2.OnlineBankingSystem.entities.FundInput;
import com.pod2.OnlineBankingSystem.entities.PinInput;
import com.pod2.OnlineBankingSystem.entities.RegisterInput;
import com.pod2.OnlineBankingSystem.entities.Users;
import com.pod2.OnlineBankingSystem.service.CustomUserDetailsService;
import com.pod2.OnlineBankingSystem.utility.GlobalResources;

/**
 * The Class controller.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class controller {

	/** The user dao. */
	@Autowired
	UserDao userDao;

	/** The login dao. */
	@Autowired
	LoginDao loginDao;

	/** The feedback dao. */
	@Autowired
	FeedbackDao feedbackDao;

	/** The custom user details service. */
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	/** The logger. */
	private Logger logger = GlobalResources.getLogger(controller.class);

	/**
	 * Register user.
	 *
	 * @param registerInput the register input
	 * @return 1,when user is created
	 */
	@PostMapping("/users/register") // localhost:2020/users/register
	@ResponseBody
	public ResponseEntity<?> registerUser(@RequestBody RegisterInput registerInput) {
		String methodName = "registerUser()";
		logger.info(methodName + "CALLED");
		int createUser = this.customUserDetailsService.createUser(registerInput);
		return ResponseEntity.ok(createUser);
	}

	/**
	 * Adds the feedback.
	 *
	 * @param feedBackInput the feed back input
	 * @return the message
	 */
	@PostMapping("/users/addfeedback")
	public ResponseEntity<?> addFeedback(@RequestBody FeedBackInput feedBackInput) {
		String methodName = "addFeedback()";
		logger.info(methodName + "CALLED");
		int message = this.customUserDetailsService.addFeedback(feedBackInput);
		return ResponseEntity.ok(message);
	}

	/**
	 * View feedback.
	 *
	 * @param username the username
	 * @return the feedback list
	 */
	@GetMapping("/users/viewfeedback/{username}")
	public ResponseEntity<?> viewFeedback(@PathVariable String username) {
		String methodName = "viewFeedback()";
		logger.info(methodName + "CALLED");
		List<FeedbackDetails> viewFeedBack = this.customUserDetailsService.viewFeedBack(username);
		return ResponseEntity.ok(viewFeedBack);

	}

	/**
	 * Show atm pin.
	 *
	 * @param pinInput the pin input
	 * @return the atm pin
	 */
	@PostMapping("/users/showatmpin")
	public ResponseEntity<?> showAtmPin(@RequestBody PinInput pinInput) {
		String methodName = " showAtmPin()";
		logger.info(methodName + "CALLED");
		int showAtmPin = this.customUserDetailsService.showAtmPin(pinInput);

		return ResponseEntity.ok(showAtmPin);

	}

	/**
	 * Fund transfer.
	 *
	 * @param fundInput the fund input
	 * @return the message
	 */
	@PostMapping("/users/fundtransfer")
	public ResponseEntity<?> fundTransfer(@RequestBody FundInput fundInput) {
		String methodName = "fundTransfer()";
		logger.info(methodName + "CALLED");
		float message = this.customUserDetailsService.fundtransfer(fundInput);
		System.out.println(message);
		return ResponseEntity.ok(message);
	}

	/**
	 * Account view.
	 *
	 * @param username the username
	 * @return the user details
	 */
	@GetMapping("/users/viewaccount/{username}")
	public ResponseEntity<?> accountView(@PathVariable String username) {
		String methodName = "accountView()";
		logger.info(methodName + "CALLED");
		Users user = this.customUserDetailsService.accountView(username);

		return ResponseEntity.ok(user);
	}

	/**
	 * Balance check.
	 *
	 * @param username the username
	 * @return the balance
	 */
	@GetMapping("/users/balancecheck/{username}")
	public ResponseEntity<?> balanceCheck(@PathVariable String username) {
		String methodName = "balanceCheck()";
		logger.info(methodName + "CALLED");
		float balance = this.customUserDetailsService.balanceCheck(username);

		return ResponseEntity.ok(balance);
	}

	/**
	 * Close account.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	@PutMapping("/users/closeAccount/{username}")
	public boolean closeAccount(@PathVariable String username) {
		String methodName = "closeAccount()";
		logger.info(methodName + "CALLED");
		boolean b = this.customUserDetailsService.closeAccount(username);
		return b;
	}

	/**
	 * get Close account status.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	@GetMapping("/users/closeAccountStatus/{username}")
	public int  closeAccountstatus(@PathVariable String username) {
		String methodName = "closeAccountStatus()";
		logger.info(methodName + "CALLED");
		int status = this.customUserDetailsService.closeAccountStatus(username);
		return status;
	}
	/**
	 * Log user out.
	 *
	 * @param username the username
	 */
	@GetMapping("/users/logout/{username}")
	public void logUserOut(@PathVariable String username) {
		this.customUserDetailsService.logout(username);

	}

	/**
	 * Adds the new user.
	 *
	 * @param newUser the new user
	 * @return the response entity
	 */
	@PostMapping("/admin/AddNewUser")
	public ResponseEntity<?> addNewUser(@RequestBody Users newUser) {
		String methodName = "addNewUser()";
		logger.info(methodName + "CALLED");
		int AddUser = this.customUserDetailsService.AddNewUser(newUser);
		return ResponseEntity.ok(AddUser);
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping("/admin/All")
	public ResponseEntity<?> getAllUsers() {
		String methodName = "getAllUsers()";
		logger.info(methodName + "CALLED");

		return ResponseEntity.ok(userDao.findAll());
	}

	/**
	 * Gets the all feedback.
	 *
	 * @return the all feedback
	 */
	@GetMapping("/admin/AllFeedback")
	public ResponseEntity<?> getAllFeedback() {
		String methodName = "getAllFeedback)";
		logger.info(methodName + "CALLED");

		return ResponseEntity.ok(feedbackDao.findAll());
	}

	/**
	 * Chnge status.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@PutMapping("/admin/changeFeedbackStatus/{id}")
	public boolean chngeStatus(@PathVariable int id) {
		String methodName = "chngeStatus()";
		logger.info(methodName + "CALLED");
		boolean b = this.customUserDetailsService.changeFeedbackStatus(id);
		return b;

	}

	/**
	 * Delete account.
	 *
	 * @param accountNumber the account number
	 * @return true, if successful
	 */
	// admin delete an account
	@DeleteMapping("/admin/deleteAccount/{accountNumber}")
	public boolean deleteAccount(@PathVariable long accountNumber) {
		String methodName = "deleteAccount()";
		logger.info(methodName + "CALLED");

		System.out.println("pathvariable is: " + accountNumber);
		boolean b = this.customUserDetailsService.deleteAccount(accountNumber);
		return b;
	}

}
