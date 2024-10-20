package calculator.service;

import java.util.List;

import calculator.domain.NumberCalculator;
import calculator.domain.Parser;
import calculator.interfaces.IOHandler;
import calculator.util.ConsoleUtil;

public class CalculatorService {
	public static final String ENTER_NUMBERS = "덧셈할 문자열을 입력해 주세요.";

	private final IOHandler ioHandler;
	private final NumberCalculator calculator;
	private final Parser parser;

	public CalculatorService() {
		this.ioHandler = new ConsoleUtil();
		this.calculator = new NumberCalculator();
		this.parser = new Parser();
	}

	public void run() {
		// 1. 문자열 입력 받는다
		ioHandler.displayMessage(ENTER_NUMBERS);
		String input = ioHandler.readLine();
		// 2. 구분자를 이용해 문자열 분리한다
		List<Integer> numbers = parser.parseInput(input);
		// 3. 분리된 숫자 더한다
		int sum = calculator.sum(numbers);
		// TODO: 결과 출력한다
		System.out.println(sum);
	}
}

