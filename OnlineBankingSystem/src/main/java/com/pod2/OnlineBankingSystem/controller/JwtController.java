package com.pod2.OnlineBankingSystem.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pod2.OnlineBankingSystem.entities.JwtModel;
import com.pod2.OnlineBankingSystem.entities.JwtResponse;
import com.pod2.OnlineBankingSystem.service.CustomUserDetailsService;
import com.pod2.OnlineBankingSystem.utility.GlobalResources;
import com.pod2.OnlineBankingSystem.utility.JwtUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtController.
 */
@RestController
@CrossOrigin
public class JwtController {

	/** The jwt util. */
	@Autowired
	private JwtUtil jwtUtil;

	/** The authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;

	/** The customer user details service. */
	@Autowired
	private CustomUserDetailsService customerUserDetailsService;

	/** The logger. */
	private Logger logger = GlobalResources.getLogger(JwtController.class);

	/**
	 * Generate token.
	 *
	 * @param jwtRequest the jwt request
	 * @return the response entity
	 * @throws Exception the exception
	 */
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<?> generateToken(@RequestBody JwtModel jwtRequest) throws Exception {

		String methodName = "LOGIN()";
		logger.info(methodName + "CALLED");
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credsentials");
		}
		// fine area..
		UserDetails userDetails = this.customerUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		logger.info("JWT " + token);
		return ResponseEntity.ok(new JwtResponse(token));

	}
}
