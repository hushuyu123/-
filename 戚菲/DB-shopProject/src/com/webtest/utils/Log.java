<<<<<<< HEAD
package com.webtest.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	static Logger logger = LogManager.getLogger();

	public static void startTestCase() {
		logger.info("----------------------");

	}

	public static void endTestCase() {
		logger.info("----------------------");

	}

	public static void fatal(String msg) {
		logger.fatal(msg);
	}

	public static void error(String msg) {
		logger.error(msg);
	}

	public static void warn(String msg) {
		logger.warn(msg);
	}

	public static void info(String msg) {
		logger.info(msg);
	}

	public static void debug(String msg) {
		logger.debug(msg);
	}
}
=======
package com.webtest.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	static Logger logger = LogManager.getLogger(Log.class);

	public static void startTestCase() {
		logger.info("----------------------");

	}

	public static void endTestCase() {
		logger.info("----------------------");

	}

	public static void fatal(String msg) {
		logger.fatal(msg);
	}

	public static void error(String msg) {
		logger.error(msg);
	}

	public static void warn(String msg) {
		logger.warn(msg);
	}

	public static void info(String msg) {
		logger.info(msg);
	}

	public static void debug(String msg) {
		logger.debug(msg);
	}
}
>>>>>>> 701e65264fd61398875288292bcacefd03779345
