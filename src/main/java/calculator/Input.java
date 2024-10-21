package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	private static final String PREFIX_CUSTOM_DELIMITER = "//";
	private static final String SUFFIX_CUSTOM_DELIMITER = "\\n";

	private static final Pattern pattern = java.util.regex.Pattern.compile("//(.*?)\\\\n");
	private static final String DEFAULT_PATTERN = "[,:]";

	public static String readInput() {
		return Console.readLine();
	}

	public static List<Integer> extractNumbers(String input) {
		String delimiter = DEFAULT_PATTERN;

		if (input.contains(PREFIX_CUSTOM_DELIMITER) || input.contains(SUFFIX_CUSTOM_DELIMITER)) {
			Matcher matcher = pattern.matcher(input);
			if (!matcher.find()) {
				throw new IllegalArgumentException("'//'와 '\\n' 둘 중 하나만 존재합니다.");
			}

			delimiter = matcher.group(1);
			if (delimiter.isBlank()) {
				throw new IllegalArgumentException("커스텀 구분자가 비어 있는 문자입니다.");
			}

			if (isNumeric(delimiter)) {
				throw new IllegalArgumentException("커스텀 구분자는 숫자일 수 없습니다.");
			}

			input = input.replace(matcher.group(0), "");
		}

		String[] splitNumbers = input.split(delimiter);

		for (String number : splitNumbers) {
			if (!isNumeric(number)) {
				throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + number);
			}
		}

		return Arrays.stream(splitNumbers)
			.map(Integer::parseInt)
			.toList();
	}

	private static boolean isNumeric(String str) {
		return str.matches("-?\\d+");
	}
}
