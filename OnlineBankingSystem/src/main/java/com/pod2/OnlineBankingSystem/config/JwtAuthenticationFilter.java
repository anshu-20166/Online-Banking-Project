package com.pod2.OnlineBankingSystem.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pod2.OnlineBankingSystem.service.CustomUserDetailsService;
import com.pod2.OnlineBankingSystem.utility.JwtUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtAuthenticationFilter.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	/** The jwt util. */
	@Autowired
	private JwtUtil jwtUtil;

	/** The customer user details service. */
	@Autowired
	private CustomUserDetailsService customerUserDetailsService;

	/**
	 * Do filter internal.
	 *
	 * @param request     the request
	 * @param response    the response
	 * @param filterChain the filter chain
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// get jwt header
		// bearer
		// validate

		String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		// null and format
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {

				username = this.jwtUtil.extractUsername(jwtToken);

			} catch (Exception e) {

				e.printStackTrace();
			}

			// security
			UserDetails userDetails = this.customerUserDetailsService.loadUserByUsername(username);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			} else {
				System.out.println("token is not validated");
			}
		}

		filterChain.doFilter(request, response);

	}

}
