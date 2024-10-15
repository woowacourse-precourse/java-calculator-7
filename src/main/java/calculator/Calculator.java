package calculator;

import java.util.Arrays;

public class Calculator {

	public int sum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		String[] number = input.split(",");

		return Arrays.stream(number).mapToInt(Integer::parseInt).sum();
	}
}
