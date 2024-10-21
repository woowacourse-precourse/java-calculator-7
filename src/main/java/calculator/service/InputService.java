package calculator.service;

import static calculator.exception.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

	private static final int ZERO = 0;
	private static final String DEFAULT_DELIMITERS = "[,:]";
	private static final String CUSTOM_DELIMITER_PREFIX = "//";
	private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
	private static final ArrayList<String> CUSTOM_DELIMITERS = new ArrayList<>();

	public String readLine() {
		return Console.readLine();
	}

	public String removeBlank(String input) {
		return input.replace(" ", "");
	}

	public String[] splitInput(String input) {
		List<Integer> prefixIndexes = findAllIndexes(input, CUSTOM_DELIMITER_PREFIX);
		List<Integer> suffixIndexes = findAllIndexes(input, CUSTOM_DELIMITER_SUFFIX);

		if (prefixIndexes.size() != suffixIndexes.size()) {
			throw new IllegalArgumentException(INVALID_INPUT.getMessage());
		}

		String numbers = input;

		if (!prefixIndexes.isEmpty() && !suffixIndexes.isEmpty()) {
			extractCustomDelimiters(input, prefixIndexes, suffixIndexes);
			numbers = replaceCustomDelimiters(numbers);
			for (String customDelimiter : CUSTOM_DELIMITERS) {
				numbers = numbers.replace(customDelimiter, ":");
			}
		}

		return numbers.split(DEFAULT_DELIMITERS);
	}

	private String replaceCustomDelimiters(String numbers) {
		for (String customDelimiter : CUSTOM_DELIMITERS) {
			numbers = numbers.replace(CUSTOM_DELIMITER_PREFIX + customDelimiter + CUSTOM_DELIMITER_SUFFIX, "");
		}
		return numbers.replace(CUSTOM_DELIMITER_PREFIX, "").replace(CUSTOM_DELIMITER_SUFFIX, "");
	}

	private void extractCustomDelimiters(String input, List<Integer> prefixIndexes,
		List<Integer> suffixIndexes) {
		for (int i = 0; i < prefixIndexes.size(); i++) {
			int startOfCustomDelimiter = prefixIndexes.get(i) + CUSTOM_DELIMITER_PREFIX.length();
			int endOfCustomDelimiter = suffixIndexes.get(i);
			String customDelimiter = input.substring(startOfCustomDelimiter, endOfCustomDelimiter);
			CUSTOM_DELIMITERS.add(customDelimiter);
		}
	}

	private List<Integer> findAllIndexes(String input, String delimiter) {
		List<Integer> indexes = new ArrayList<>();
		int index = input.indexOf(delimiter);
		while (ZERO <= index) {
			indexes.add(index);
			index = input.indexOf(delimiter, index + delimiter.length());
		}
		return indexes;
	}
}
