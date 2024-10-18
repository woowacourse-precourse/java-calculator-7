package calculator.service;

public class CalculatorService {
	private String line;

	public CalculatorService(String line) {
		validate(line);
		this.line = line;
	}

	private void validate(String line) {
		if (line == null)
			throw new IllegalArgumentException("입력값이 null입니다.");
	}

}
