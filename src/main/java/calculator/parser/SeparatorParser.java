package calculator.parser;

import java.util.Set;

public interface SeparatorParser {

	public String parse(String text, Set<Character> separators);

	public String generateRegex(Set<Character> separators);
}
