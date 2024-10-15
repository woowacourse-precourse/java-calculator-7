package calculator.model;

import java.util.Arrays;
import java.util.List;

public class InputParser {
	List<String> delimiters = Arrays.asList(",", ":");

	private boolean hasCustomDelimiter(String input) {
		return input.startsWith("//");
	}
}
