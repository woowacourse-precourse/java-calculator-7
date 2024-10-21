package calculator.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
	private final Pattern hasCustomDelimiter = Pattern.compile("^//(.*?)\\\\n$");

	public String[] validateInputSplittable(String input) {
		String delimiter = "[:,]";

		// 커스텀 구분자 있는지 체크
		if (input.length() >= 5) {
			Matcher matcher = hasCustomDelimiter.matcher(input.substring(0, 5));
			int position = 0;
			if (matcher.find()) {
				delimiter = matcher.group(1);
				position = 5;
			}
			return input.substring(position)
				.split(delimiter);
		}



		return input.split(delimiter);

	}

	public List<Integer> validatePositiveNumbers(String[] numberStrings) {
		return Arrays.stream(numberStrings)
			.map(s -> {
				try {
					if(s.isEmpty()){
						return 0;
					}
					return Integer.parseUnsignedInt(s);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException();
				}
			})
			.toList();
	}
}
