package calculator.service;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
	private final String PATTERN = "//;\\n";
	private final int DELIMITER_INDEX = 2;
	private String line;
	private String delimiter = ":,";

	public CalculatorService(String line) {
		this.line = validate(line);
	}

	private String validate(String line) {
		if (line == null)
			throw new IllegalArgumentException("입력값이 null입니다.");
		if (!line.isBlank() && line.charAt(0) == PATTERN.charAt(0))
			line = findDelimiter(line);
		return line;
	}

	private String findDelimiter(String line) {
		for (int i = 0; i < PATTERN.length(); i++) {
			if (i == DELIMITER_INDEX)
				continue;
			if (PATTERN.charAt(i) != line.charAt(i))
				throw new IllegalArgumentException("구분자 패턴이 아닙니다.");
		}
		delimiter += line.charAt(DELIMITER_INDEX);
		return line.substring(PATTERN.length());
	}

	public List<Integer> getNumbers() {
		List<Integer> numbers = new ArrayList<>();
		if (line.isBlank())
			return numbers;
		for (String number : line.split("[" + delimiter + "]")) {
			int item = 0;
			try {
				item = Integer.parseInt(number);
			} catch (Exception e) {
				throw new IllegalArgumentException("구분된 문자열이 숫자가 아닙니다.");
			}
			numbers.add(item);
		}
		return numbers;
	}
}
