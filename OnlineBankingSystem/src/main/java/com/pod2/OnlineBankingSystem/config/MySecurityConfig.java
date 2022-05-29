package com.pod2.OnlineBankingSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pod2.OnlineBankingSystem.service.CustomUserDetailsService;

// TODO: Auto-generated Javadoc
/**
 * The Class MySecurityConfig.
 */
@SuppressWarnings("deprecation")
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	/** The customer user details service. */
	@Autowired
	private CustomUserDetailsService customerUserDetailsService;

	/** The jwt filter. */
	@Autowired
	private JwtAuthenticationFilter jwtFilter;

	/** The entrypoint. */
	@Autowired
	private JwtAuthenticationEntryPoint entrypoint;

	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login", "/users/register").permitAll().anyRequest()
				.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.exceptionHandling().authenticationEntryPoint(entrypoint);
		http.cors();

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/**
	 * Configure.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	// over
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customerUserDetailsService);
	}

	/**
	 * Password encoder.
	 *
	 * @return the password encoder
	 */
	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/**
	 * Authentication manager bean.
	 *
	 * @return the authentication manager
	 * @throws Exception the exception
	 */
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
