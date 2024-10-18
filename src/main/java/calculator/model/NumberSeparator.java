package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import calculator.constant.CommonPattern;
import calculator.constant.DefaultDelimiter;

public class NumberSeparator {
	private static final int CUSTOM_DELIMITER_POSITION = 1;
	private static final int EQUATION_POSITION = 2;
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(
		CommonPattern.START_WITH +
		CUSTOM_DELIMITER_PREFIX +
		CommonPattern.GROUP +
		CUSTOM_DELIMITER_POSTFIX +
		CommonPattern.GROUP
	);

	private final String equation;
	private final List<Delimiter> delimiters;

	private NumberSeparator(String input) {
		delimiters = DefaultDelimiter.getDefaultDelimiter();

		if (hasCustomDelimiter(input)) {
			delimiters.add(extractCustomDelimiter(input));
			equation = extractEquation(input);
			return;
		}

		equation = input;
	}

	public static NumberSeparator from(String input) {
		return new NumberSeparator(input);
	}

	private boolean hasCustomDelimiter(String input) {
		return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
	}

	private Delimiter extractCustomDelimiter(String input) {
		return Delimiter.from(
			CUSTOM_DELIMITER_PATTERN.matcher(input).group(CUSTOM_DELIMITER_POSITION)
		);
	}

	private String extractEquation(String input) {
		return CUSTOM_DELIMITER_PATTERN.matcher(input).group(EQUATION_POSITION);
	}

	Numbers separate() {
		return Numbers.parseNumbers(
			Arrays.stream(
				equation.split(Delimiter.toRegex(delimiters))
			).toList()
		);
	}
}