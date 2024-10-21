package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final String DEFAULT_DELIMITERS = ",|:";

	public int add(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		String delimiter = DEFAULT_DELIMITERS;
		if (input.startsWith("//")) {
			Matcher matcher = Pattern.compile("//(.*?)\n(.*)").matcher(input);
			if (matcher.matches()) {
				delimiter = Pattern.quote(matcher.group(1));
				input = matcher.group(2);
			}
		}

		return calculateSum(input, delimiter);
	}

	private int calculateSum(String input, String delimiter) {
		String[] numbers = input.split(delimiter);
		int sum = 0;
		for (String number : numbers) {
			int num = parseNumber(number);
			sum += num;
		}
		return sum;
	}

	private int parseNumber(String number) {
		int num = Integer.parseInt(number);
		if (num < 0) {
			throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
		}
		return num;
	}
}
