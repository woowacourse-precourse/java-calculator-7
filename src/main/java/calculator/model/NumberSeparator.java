package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.constant.CommonPattern;
import calculator.constant.DefaultDelimiter;

public class NumberSeparator {
	private static final int CUSTOM_DELIMITER_POSITION = 1;
	private static final int EQUATION_POSITION = 2;
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_POSTFIX = "\\\\n";

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(
		CommonPattern.START_WITH +
		CUSTOM_DELIMITER_PREFIX +
		CommonPattern.GROUP +
		CUSTOM_DELIMITER_POSTFIX +
		CommonPattern.GROUP +
		CommonPattern.END_WITH
	);

	private final String equation;
	private final List<Delimiter> delimiters = new ArrayList<>();

	private NumberSeparator(String input) {
		delimiters.addAll(DefaultDelimiter.getDefaultDelimiter());

		Matcher matcher = getMatcher(input);
		if (hasCustomDelimiter(matcher)) {
			delimiters.add(extractCustomDelimiter(matcher));
			equation = extractEquation(matcher);
			return;
		}

		equation = input;
	}

	public static NumberSeparator from(String input) {
		return new NumberSeparator(input);
	}

	private Matcher getMatcher(String input) {
		return CUSTOM_DELIMITER_PATTERN.matcher(input);
	}

	private boolean hasCustomDelimiter(Matcher matcher) {
		return matcher.find();
	}

	private Delimiter extractCustomDelimiter(Matcher matcher) {
		return Delimiter.from(
			matcher.group(CUSTOM_DELIMITER_POSITION)
		);
	}

	private String extractEquation(Matcher matcher) {
		return matcher.group(EQUATION_POSITION);
	}

	public Numbers separate() {
		return Numbers.parseNumbers(
			Arrays.stream(
				equation.split(Delimiter.toRegex(delimiters))
			).toList()
		);
	}
}