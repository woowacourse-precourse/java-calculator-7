package calculator.service;

import java.util.List;

import calculator.domain.NumberCalculator;
import calculator.domain.Parser;
import calculator.interfaces.IOHandler;
import calculator.util.ConsoleUtil;

public class CalculatorService {
	public static final String ENTER_NUMBERS = "덧셈할 문자열을 입력해 주세요.";
	public static final String DISPLAY_RESULT = "결과 : ";

	private final IOHandler ioHandler;
	private final NumberCalculator calculator;
	private final Parser parser;

	public CalculatorService() {
		this.ioHandler = new ConsoleUtil();
		this.calculator = new NumberCalculator();
		this.parser = new Parser();
	}

	public void run() {
		ioHandler.displayMessage(ENTER_NUMBERS);
		String input = ioHandler.readLine();
		List<Integer> numbers = parser.parseInput(input);
		ioHandler.displayMessage(DISPLAY_RESULT + calculator.sum(numbers));
	}
}

