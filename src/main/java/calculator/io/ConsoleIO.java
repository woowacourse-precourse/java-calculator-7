package calculator.io;

public class ConsoleIO {
	private final Reader reader;
	private final Writer writer;

	public ConsoleIO(Reader reader, Writer writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public String readExpression() {
		writer.write("덧셈할 문자열을 입력해 주세요.");

		String input = reader.read();
		validateInput(input);

		return input;
	}

	private void validateInput(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("값을 입력해야 합니다.");
		}
	}

	public void writeResult(int result) {
		writer.write("결과 : " + result);
	}
}
