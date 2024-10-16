package calculator.parser;

import java.util.Set;
import java.util.StringTokenizer;

public class BasicSeparatorParser implements SeparatorParser {

	private boolean isValid(String text) {
		if (text.length() > 2 && text.startsWith("//")) {
			return true;
		} else {
			throw new IllegalArgumentException(ParserError.INVALID_FORMAT_SEPARATOR.getMessage());
		}
	}

	@Override
	public String parse(String text, Set<Character> separators) {
		StringTokenizer tokenizer = new StringTokenizer(text, "\\n");
		while (tokenizer.countTokens() > 1) {
			String now = tokenizer.nextToken();

			if (isValid(now)) {
				String separator = now.substring(2, now.length());
				if (!separators.add(separator)) {
					throw new IllegalArgumentException(ParserError.DUPLICATION_SEPARATOR.getMessage());
				}
			}
		}

		String mathematicalExpression = tokenizer.nextToken();
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
