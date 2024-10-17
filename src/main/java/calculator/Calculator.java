package calculator;

import java.util.logging.Logger;

import calculator.util.ConsoleInputUtil;
import calculator.util.LoggerFactory;

public class Calculator {
	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);
	private final ConsoleInputUtil inputReader;

	public Calculator() {
		this.inputReader = new ConsoleInputUtil();
	}

	public void run() {
		// 1. 문자열 입력 받는다
		String input = inputReader.readInput();
		// TODO: 구분자를 이용해 문자열 분리한다
		// TODO: 분리된 숫자 더한다
		// TODO: 커스텀 구분자 지정한다
		// TODO: 잘못된 입력에 대한 IllegalArgumentException 예외 처리한다
		// TODO: 결과 출력한다
	}
}