package calculator.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import calculator.model.delimiter.Delimiters;
import calculator.validation.InputValidator;

public class InputFilter {
	/**
	 * 핵심 로직
	 */
	// 1차 가공된 입력값에서 숫자를 추출
	public List<Integer> extractNumbers(String processedInput, Delimiters delimiters) {
		if (processedInput.isBlank()) {
			return List.of();
		}
		String[] splitParts = splitInput(processedInput, delimiters);
		validateEachPart(splitParts);

		return Collections.unmodifiableList(getExtractedNumbers(splitParts));
	}

	// 구분자들을 이용해 정규식을 만들고, 이를 이용해 입력값을 분리
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

	private static List<Integer> getExtractedNumbers(String[] splitParts) {
		return Arrays.stream(splitParts)
			.map(Integer::valueOf)
			.toList();
	}
}
