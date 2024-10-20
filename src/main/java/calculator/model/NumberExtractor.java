package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class NumberExtractor {

	private static final int INPUT_START_INDEX = 0;
	private static final int DELIMITER_LENGTH = 1;

	public List<Integer> extractNumbers(String input) {
		List<Integer> numbers = new ArrayList<>();
		int index = INPUT_START_INDEX;
		while (index < input.length()) {
			int endIndex = getNumberRange(input, index);
			int number = Integer.parseInt(input.substring(index, endIndex));
			numbers.add(number);
			index = endIndex + DELIMITER_LENGTH;
		}
		return numbers;
	}

	private int getNumberRange(String input, int index) {
		while (index < input.length() && Character.isDigit(input.charAt(index))) {
			index++;
		}
		return index;
	}
}
