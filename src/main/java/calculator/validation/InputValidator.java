package calculator.validation;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
	List<String> delimiters;

	public void validateInput(String input) {
		delimiters = Arrays.asList(",", ":");
	}
}
