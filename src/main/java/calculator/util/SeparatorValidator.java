package calculator.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import calculator.common.ErrorMessages;
import calculator.common.LoggerFactory;

public class SeparatorValidator {
	private static final Logger logger = LoggerFactory.getLogger(SeparatorValidator.class);
	private static final String CUSTOM_SEPARATOR_PREFIX = "//";

	public void validate(String part) {
		validatePrefix(part);
		validateLength(part);
		validateNotNumeric(part);
	}

	private void validatePrefix(String part) {
		if (!part.startsWith(CUSTOM_SEPARATOR_PREFIX)) {
			logger.log(Level.SEVERE, ErrorMessages.CUSTOM_SEPARATOR_PREFIX.getMessage());
			throw new IllegalArgumentException(part);
		}
	}

	private void validateLength(String part) {
		if (part.length() != CUSTOM_SEPARATOR_PREFIX.length() + 1) {
			logger.log(Level.SEVERE, ErrorMessages.CUSTOM_SEPARATOR_LENGTH.getMessage());
			throw new IllegalArgumentException(part);
		}
	}

	private void validateNotNumeric(String part) {
		char separator = part.charAt(CUSTOM_SEPARATOR_PREFIX.length());
		if (Character.isDigit(separator)) {
			logger.log(Level.SEVERE, ErrorMessages.CUSTOM_SEPARATOR_NUMERIC.getMessage());
			throw new IllegalArgumentException(part);
		}
	}
}