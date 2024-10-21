package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public int separateInput(String input) {
		String delimiter = ",|:";
		String numbers = input;

		Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
		if (matcher.matches()) {
			delimiter = Pattern.quote(matcher.group(1));
			numbers = matcher.group(2);
		}

		return sumNumbers(numbers, delimiter);
	}

	private int sumNumbers(String numbers, String delimiter) {
		String[] tokens = separateNumbers(numbers, delimiter);
		int sum = 0;

		for (String token : tokens) {
			if (!token.isEmpty()) {
				int number = convertNumber(token);
				sum += number;
			}
		}
		return sum;
	}

	private String[] separateNumbers(String numbers, String delimiter) {
		return numbers.split(delimiter);
	}

	private int convertNumber(String token) {
		int number = Integer.parseInt(token);
		validateIsInputNegative(number);
		return number;
	}

	private void validateIsInputNegative(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
		}
	}
}