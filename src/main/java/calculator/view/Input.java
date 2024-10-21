package calculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\\\n";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = java.util.regex.Pattern.compile("//(.*?)\\\\n");
	private static final String DEFAULT_PATTERN = "[,:]";

	public static String readInput() {
		return Console.readLine();
	}

	public static List<Integer> extractNumbers(String input) {
		String delimiter = DEFAULT_PATTERN;

		if (hasCustomDelimiter(input)) {
			delimiter = extractCustomDelimiter(input);
			input = removeDelimiterDefinition(input, delimiter);
		}

		String[] splitNumbers = input.split(delimiter);

		validateNumbers(splitNumbers);

		return Arrays.stream(splitNumbers)
			.map(Integer::parseInt)
			.toList();
	}

	private static boolean hasCustomDelimiter(String input) {
		return input.startsWith(CUSTOM_DELIMITER_PREFIX);
	}

	private static String extractCustomDelimiter(String input) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (!matcher.find()) {
			throw new IllegalArgumentException("Custom delimiter syntax is incorrect. Expected format: //delimiter\\n");
		}

		String delimiter = matcher.group(1);
		if (delimiter.isBlank()) {
			throw new IllegalArgumentException("Custom delimiter cannot be blank.");
		}

		if (isNumeric(delimiter)) {
			throw new IllegalArgumentException("Custom delimiter cannot be a numeric value.");
		}

		return delimiter;
	}

	private static String removeDelimiterDefinition(String input, String delimiter) {
		return input.replaceFirst(CUSTOM_DELIMITER_PREFIX + Pattern.quote(delimiter) + CUSTOM_DELIMITER_SUFFIX, "");
	}

	private static void validateNumbers(String[] splitNumbers) {
		for (String number : splitNumbers) {
			if (!isNumeric(number)) {
				throw new IllegalArgumentException("Invalid input. Non-numeric value found: " + number);
			}
		}
	}

	private static boolean isNumeric(String str) {
		return str.matches("-?\\d+");
	}
}
