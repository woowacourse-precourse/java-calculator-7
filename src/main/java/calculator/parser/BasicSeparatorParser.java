package calculator.parser;

import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicSeparatorParser implements SeparatorParser {


	public static final String BASIC_CUSTOM_SEPARATOR_PATTERN = "(/{2})(\\D)(\\\\n)";
	private static final Pattern PATTERN = Pattern.compile(BASIC_CUSTOM_SEPARATOR_PATTERN);
	private Matcher matcher;

	@Override
	public String parse(String text, Set<Character> separators) {
		matcher = PATTERN.matcher(text);

		while (matcher.find()) {
			char customSeparator = matcher.group(2).charAt(0);

			if(!separators.add(customSeparator)){
				throw new IllegalArgumentException(ParserError.DUPLICATION_SEPARATOR.getMessage());
			}
		}

		String mathematicalExpression = text.replaceAll(BASIC_CUSTOM_SEPARATOR_PATTERN, "");
		return mathematicalExpression;
	}

	@Override
	public String generateRegex(Set<Character> separators) {
		if (separators.isEmpty()) {
			return "";
		}
		StringBuilder separatorRegex = new StringBuilder();

		for (char separator : separators) {
			separatorRegex.append("|").append(separator);
		}

		separatorRegex.deleteCharAt(0);
		return separatorRegex.toString();
	}

}
