package calculator.model;

import java.util.List;
import java.util.regex.Pattern;

import calculator.constant.CommonPattern;
import calculator.constant.DefaultDelimiter;

public class NumberSeparator {
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(
		CommonPattern.START_WITH +
		CUSTOM_DELIMITER_PREFIX +
		CommonPattern.GROUP +
		CUSTOM_DELIMITER_POSTFIX +
		CommonPattern.GROUP
	);

	private final List<Delimiter> delimiters;

	private NumberSeparator(String input) {
		this.delimiters = DefaultDelimiter.getDefaultDelimiter();
	}

	public static NumberSeparator from(String input) {
		return new NumberSeparator(input);
	}

	private boolean hasCustomDelimiter(String input) {
		return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
	}
}