package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import calculator.constant.ErrorMessage;
import calculator.util.NumberChecker;

public class NumberExtractor {

	private static final String OR_SIGN = "|";
	private static final long ZERO = 0L;
	private static final int STRING_START_INDEX = 0;
	private static final String NUMBER_REGEX = "\\d";

	public List<Long> getNumbers(String numberSection, List<String> delimiters) {

		if (numberSection.isBlank()) {
			return new ArrayList<>(List.of(ZERO));
		}
		validateNumberSection(numberSection, delimiters);

		String delimiter = String.join(OR_SIGN, delimiters);
		String[] split = numberSection.split(delimiter);
		Arrays.stream(split)
			.forEach(this::validateNumber);

		return Arrays.stream(split)
			.map(this::validateRangeAndParse)
			.toList();
	}

	private void validateNumberSection(String numberSection, List<String> delimiters) {
		validateStartWithDelimiter(numberSection, delimiters);
		validateEndWithDelimiter(numberSection, delimiters);
		validateUsingUnregisteredDelimiter(numberSection, delimiters);
	}

	private void validateUsingUnregisteredDelimiter(String numberSection, List<String> delimiters) {

		String[] split = numberSection.split(NUMBER_REGEX);
		Arrays.stream(split)
			.filter(delimiter -> !delimiters.contains(delimiter) && !delimiter.isBlank())
			.findAny()
			.ifPresent(delimiter -> {
				throw new IllegalArgumentException(ErrorMessage.USE_UNREGISTERED_DELIMITER.getMessage() + delimiter);
			});
	}

	private void validateStartWithDelimiter(String numberSection, List<String> delimiters) {

		for (String delimiter : delimiters) {
			int startValueLength = delimiter.length();
			String startValue = numberSection.substring(STRING_START_INDEX, startValueLength);

			if (delimiters.contains(startValue)) {
				throw new IllegalArgumentException(ErrorMessage.START_WITH_DELIMITER.getMessage());
			}
		}
	}

	private void validateEndWithDelimiter(String numberSection, List<String> delimiters) {

		for (String delimiter : delimiters) {
			int endValueStartIndex = numberSection.length() - delimiter.length();
			String endValue = numberSection.substring(endValueStartIndex);

			if (delimiters.contains(endValue)) {
				throw new IllegalArgumentException(ErrorMessage.END_WITH_DELIMITER.getMessage());
			}
		}
	}

	private void validateNumber(String number) {
		validateUsingContinuousDelimiter(number);
		validateNumberFormat(number);
		validateUsingNegativeNumber(number);
	}

	private void validateUsingContinuousDelimiter(String number) {
		if (number.isBlank()) {
			throw new IllegalArgumentException(ErrorMessage.USE_CONTINUOUS_DELIMITER.getMessage());
		}
	}

	private void validateNumberFormat(String number) {
		if (NumberChecker.isNotNumber(number)) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
		}
	}

	private void validateUsingNegativeNumber(String number) {
		if (NumberChecker.isNegativeNumber(number)) {
			throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED.getMessage());
		}
	}

	private long validateRangeAndParse(String number) {
		try {
			return Long.parseLong(number);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException(ErrorMessage.OVER_FLOW_INPUT_VALUE.getMessage());
		}
	}

}
