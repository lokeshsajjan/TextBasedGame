package com.company.cli.adapter.exception;

public class ConfigurationException extends Exception {
	public ConfigurationException(String message) {
		super(message);
	}

	public ConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}
}
