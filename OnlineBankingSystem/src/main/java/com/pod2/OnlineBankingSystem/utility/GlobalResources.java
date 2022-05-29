package com.pod2.OnlineBankingSystem.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class GlobalResources.
 */
public class GlobalResources {

	/**
	 * Gets the logger.
	 *
	 * @param className the class name
	 * @return the logger
	 */
	public static Logger getLogger(@SuppressWarnings("rawtypes") Class className) {
		return LoggerFactory.getLogger(className);
	}
}
