package calculator.service;

import java.util.List;
import java.util.logging.Logger;

import calculator.domain.NumberCalculator;
import calculator.interfaces.IOHandler;
import calculator.util.ConsoleUtil;
import calculator.util.LoggerFactory;
import calculator.util.Parser;

public class CalculatorService {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
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
		String input = ioHandler.readInput();
		// 2. 구분자를 이용해 문자열 분리한다
		List<Integer> numbers = parser.stringToInt(input);
		// 3. 분리된 숫자 더한다
		int sum = calculator.sum(numbers);
		// TODO: 잘못된 입력에 대한 IllegalArgumentException 예외 처리한다
		// TODO: 결과 출력한다
		System.out.println(sum);
	}
}

