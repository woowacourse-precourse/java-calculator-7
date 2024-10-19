package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import calculator.util.NumberChecker;

public class NumberExtractor {

	private static final String OR_SIGN = "|";
	private static final long ZERO = 0L;

	public List<Long> getNumbers(String numberSection, List<String> delimiters) {

		if(numberSection.isBlank()) {
			return new ArrayList<>(List.of(ZERO));
		}

		String delimiter = String.join(OR_SIGN, delimiters);
		String[] split = numberSection.split(delimiter);
		Arrays.stream(split)
			.forEach(this::validateNumber);

		return Arrays.stream(split)
			.map(Long::parseLong)
			.toList();
	}

	private void validateNumber(String number) {
		validateNumberFormat(number);
		validatePositiveNumber(number);
	}

	private void validateNumberFormat(String number) {
		if (NumberChecker.isNotNumber(number)) {
			throw new IllegalArgumentException("Not a number: " + number);
		}
	}

	private void validatePositiveNumber(String number) {
		if (NumberChecker.isNegativeNumber(number)) {
			throw new IllegalArgumentException("Negative number: " + number);
		}
	}

}
