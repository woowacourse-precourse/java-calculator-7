package calculator.service;

import java.util.List;
import java.util.logging.Logger;

import calculator.util.ConsoleInputUtil;
import calculator.util.LoggerFactory;
import calculator.util.Parser;

public class CalculatorService {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

	private final ConsoleInputUtil inputReader;
	private final Parser parser;

	public CalculatorService() {
		this.inputReader = new ConsoleInputUtil();
		this.parser = new Parser();
	}

	public void run() {
		// 1. 문자열 입력 받는다
		String input = inputReader.readInput();
		// 2. 구분자를 이용해 문자열 분리한다
		List<Integer> numbers = parser.stringToInt(input);
		System.out.println(numbers);
		// TODO: 분리된 숫자 더한다
		// TODO: 잘못된 입력에 대한 IllegalArgumentException 예외 처리한다
		// TODO: 결과 출력한다
	}
}

