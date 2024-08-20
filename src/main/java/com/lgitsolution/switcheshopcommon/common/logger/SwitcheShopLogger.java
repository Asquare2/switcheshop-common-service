
package com.lgitsolution.switcheshopcommon.common.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Class SelfKartLogger.
 */
public class SwitcheShopLogger {
	
	/** The logger. */
	Logger logger;

	/**
	 * Instantiates a new self kart logger.
	 *
	 * @param clazz the clazz
	 */
	public SwitcheShopLogger(Class clazz) {
		this.logger = LogManager.getLogger(clazz);
	}
	
	 /**
     * Log a fatal message.
     *
     * @param message the fatal message
     */
    public void fatal(String message) {
        logger.fatal(message);
    }

    /**
     * Log a fatal message with a throwable.
     *
     * @param message   the fatal message
     * @param throwable the throwable
     */
    public void fatal(String message, Throwable throwable) {
        logger.fatal(message, throwable);
    }

    /**
     * Log an error message.
     *
     * @param message the error message
     */
    public void error(String message) {
        logger.error(message);
    }

    /**
     * Log an error message with a throwable.
     *
     * @param message   the error message
     * @param throwable the throwable
     */
    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    /**
     * Log a warning message.
     *
     * @param message the warning message
     */
    public void warn(String message) {
        logger.warn(message);
    }

    /**
     * Log a warning message with a throwable.
     *
     * @param message   the warning message
     * @param throwable the throwable
     */
    public void warn(String message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    /**
     * Log an info message.
     *
     * @param message the info message
     */
    public void info(String message) {
        logger.info(message);
    }

    /**
     * Log an info message with a throwable.
     *
     * @param message   the info message
     * @param throwable the throwable
     */
    public void info(String message, Throwable throwable) {
        logger.info(message, throwable);
    }

    /**
     * Log a debug message.
     *
     * @param message the debug message
     */
    public void debug(String message) {
        logger.debug(message);
    }

    /**
     * Log a debug message with a throwable.
     *
     * @param message   the debug message
     * @param throwable the throwable
     */
    public void debug(String message, Throwable throwable) {
        logger.debug(message, throwable);
    }

    /**
     * Log a trace message.
     *
     * @param message the trace message
     */
    public void trace(String message) {
        logger.trace(message);
    }

    /**
     * Log a trace message with a throwable.
     *
     * @param message   the trace message
     * @param throwable the throwable
     */
    public void trace(String message, Throwable throwable) {
        logger.trace(message, throwable);
    }	
}
