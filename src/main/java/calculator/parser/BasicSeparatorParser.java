package calculator.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicSeparatorParser implements SeparatorParser {

	public static final String BASIC_CUSTOM_SEPARATOR_PATTERN = "(/{2})(\\D)(\\\\n)";
	public static final String BASIC_VALID_CUSTOM_SEPARATOR_PATTERN = "^(/{2}\\D\\\\n)+(\\d+\\D)*\\d+$";
	private static final Pattern PATTERN = Pattern.compile(BASIC_CUSTOM_SEPARATOR_PATTERN);
	private static final List<Character> BASIC_SEPARATORS = Arrays.asList(new Character[] {',', ':'});
	private Matcher matcher;

	private static void isValid(String expression) {
		if (!expression.matches(BASIC_VALID_CUSTOM_SEPARATOR_PATTERN)) {
			throw new IllegalArgumentException(ParserError.INVALID_FORMAT_SEPARATOR.getMessage());
		}
	}

	@Override
	public String parse(String expression, Set<Character> separators) {
		isValid(expression);
		matcher = PATTERN.matcher(expression);
		separators.addAll(BASIC_SEPARATORS);

		while (matcher.find()) {
			char customSeparator = matcher.group(2).charAt(0);

			if (!separators.add(customSeparator)) {
				throw new IllegalArgumentException(ParserError.DUPLICATION_SEPARATOR.getMessage());
			}
		}

		String mathematicalExpression = expression.replaceAll(BASIC_CUSTOM_SEPARATOR_PATTERN, "");
		return mathematicalExpression;
	}

	@Override
	public String generateRegex(Set<Character> separators) {
		if (separators.isEmpty()) {
			return "";
		}
		StringBuilder separatorPattern = new StringBuilder();

		for (char separator : separators) {
			separatorPattern.append("|").append(separator);
		}

		separatorPattern.deleteCharAt(0);
		return separatorPattern.toString();
	}

}
