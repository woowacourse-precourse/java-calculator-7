package calculator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import calculator.model.delimiter.Delimiters;
import calculator.validation.InputValidator;

public class InputFilter {
	public List<Integer> extractNumbers(String processedInput, Delimiters delimiters) {
		if (processedInput.isBlank()) {
			return List.of(0);
		}
		String[] splitParts = splitInput(processedInput, delimiters);
		validateEachPart(splitParts);

		return Collections.unmodifiableList(mapToInteger(splitParts));
	}

	private String[] splitInput(String processedInput, Delimiters delimiters) {
		InputValidator.validateInvalidDelimiter(processedInput, delimiters);
		String regex = String.join("|", delimiters.getRegex());

		return processedInput.split(regex);
	}

	private static void validateEachPart(String[] splitParts) {
		Arrays.stream(splitParts)
			.map(String::trim)
			.forEach(InputValidator::validateCalculatorNumber);
	}

	private static List<Integer> mapToInteger(String[] splitParts) {
		return Arrays.stream(splitParts)
			.map(Integer::valueOf)
			.toList();
	}
}
