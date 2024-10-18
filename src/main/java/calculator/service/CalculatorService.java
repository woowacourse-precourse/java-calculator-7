package calculator.service;

public class CalculatorService {
	private final String pattern = "//;\\n";
	private String line;
	private String delimiter = ":,";

	public CalculatorService(String line) {
		validate(line);
		this.line = line;
	}

	private void validate(String line) {
		if (line == null)
			throw new IllegalArgumentException("입력값이 null입니다.");
		if (line.charAt(0) == pattern.charAt(0))
			line = findDelimiter(line);
	}

	private String findDelimiter(String line) {
		for (int i = 0; i < pattern.length(); i++) {
			if (i == 2)
				continue;
			if (pattern.charAt(i) != line.charAt(i))
				throw new IllegalArgumentException("구분자 패턴이 아닙니다.");
		}
		delimiter += line.charAt(2);
		return line.substring(pattern.length());
	}

}
