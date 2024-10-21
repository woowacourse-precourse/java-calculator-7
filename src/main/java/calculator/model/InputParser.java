package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import calculator.validation.InputValidator;

public class InputParser {
	private InputParser() {
	}

	/**
	 * 핵심 로직
	 */
	// 1차 가공된 입력값에서 숫자를 추출
	public static List<Integer> extractNumbers(String processedInput, Delimiter delimiter) {
		if (processedInput.isBlank()) {
			return List.of();
		}
		String[] splitParts = splitInput(processedInput, delimiter);

		return saveNumbers(splitParts);
	}

	// 구분자들을 이용해 정규식을 만들고, 이를 이용해 입력값을 분리
	private static String[] splitInput(String processedInput, Delimiter delimiter) {
		InputValidator.validateInvalidDelimiter(processedInput, delimiter);

		String regex = String.join("|",
			delimiter.getDelimiters().stream()
				.map(Pattern::quote) // 구분자를 정규식에 안전하게 포함 (특수 문자의 경우 혼동의 여지가 있음)
				.toArray(String[]::new)
		);

		return processedInput.split(regex);
	}

	// 분리된 각 부분에서 숫자로 변환하여 리스트에 추가
	private static List<Integer> saveNumbers(String[] splitParts) {
		List<Integer> numbers = new ArrayList<>();
		Arrays.stream(splitParts)
			.map(String::trim)
			.forEach(part -> {
				InputValidator.validateDigit(part);
				InputValidator.validateNumberPositive(part);
				numbers.add(Integer.parseInt(part));
			});

		return numbers;
	}
}
