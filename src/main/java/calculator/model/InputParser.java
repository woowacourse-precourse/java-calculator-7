package calculator.model;

import java.util.Arrays;
import java.util.List;

public class InputParser {
	List<String> delimiters = Arrays.asList(",", ":");

	private String addCustomDelimiter(String input) {
		int delimiterStart = input.indexOf("//") + 2;
		int delimiterEnd = input.indexOf("\n");

		return input.substring(delimiterStart, delimiterEnd);
	}

	public String removeCustomDelimiter(String input) {
		if (hasCustomDelimiter(input)) {
			int delimiterEnd = input.indexOf("\n");

			return input.substring(delimiterEnd + 1); // \n 이후의 문자열 반환
		}

		return input; // 커스텀 구분자가 없을 경우 원본 문자열 반환
	}

	private boolean hasCustomDelimiter(String input) {
		return input.startsWith("//");
	}
}
