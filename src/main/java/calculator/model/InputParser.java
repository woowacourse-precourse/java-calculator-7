package calculator.model;

import java.util.Arrays;
import java.util.List;

public class InputParser {
	List<String> delimiters = Arrays.asList(",", ":");

	private String addCustomDelimiter(String input) {
		int delimiterStart = input.indexOf("//") + 2;
		int delimiterEnd = input.indexOf("\n");

		return input.substring(delimiterStart, delimiterEnd);
	}

	private boolean hasCustomDelimiter(String input) {
		return input.startsWith("//");
	}
}
