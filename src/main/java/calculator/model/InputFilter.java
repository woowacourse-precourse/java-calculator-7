package calculator.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import calculator.model.delimiter.Delimiters;
import calculator.validation.InputValidator;

public class InputFilter {
	public Set<Integer> extractNumbers(String processedInput, Delimiters delimiters) {
		if (processedInput.isBlank()) {
			return Set.of(0);
		}
		String[] splitParts = splitInput(processedInput, delimiters);
		validateEachPart(splitParts);

		return mapToIntegerSet(splitParts);
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

	private static Set<Integer> mapToIntegerSet(String[] splitParts) {
		return Arrays.stream(splitParts)
			.map(Integer::valueOf)
			.collect(Collectors.toUnmodifiableSet());
	}
}
