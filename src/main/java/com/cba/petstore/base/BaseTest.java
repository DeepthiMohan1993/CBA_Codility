package com.cba.petstore.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {

	public static String baseUri;
	public static String path;
	public static String uploadPath;
	public static String petById;

	protected static final Logger logger = LogManager.getLogger();

	public void logMessage(String log, String message) {
		switch (log) {
		case "Info":
			logger.info(message);
			break;
		case "Error":
			logger.error(message);
			break;
		case "Pass":
			logger.debug(message);
			break;
		default:
			logger.warn("Invalid log level: " + log);
		}

	}
}
