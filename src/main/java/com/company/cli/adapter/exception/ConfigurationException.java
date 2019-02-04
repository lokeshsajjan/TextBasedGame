package com.company.cli.adapter.exception;

/**
 * @author lsajjan
 *
 */
public class ConfigurationException extends Exception {
	/**
	 * @param message
	 */
	public ConfigurationException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}
}
