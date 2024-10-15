package calculator.parser;

import java.util.Set;

public interface SeparatorParser {

	public String parse(String text, Set<String> separators);
	public String generateRegex(Set<String> separators);
}
