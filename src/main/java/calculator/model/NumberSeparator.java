package calculator.model;

import java.util.List;

import calculator.constant.DefaultDelimiter;

public class NumberSeparator {
	private final List<Delimiter> delimiters;

	private NumberSeparator(String input) {
		this.delimiters = DefaultDelimiter.getDefaultDelimiter();
	}

	public static NumberSeparator from(String input) {
		return new NumberSeparator(input);
	}
}