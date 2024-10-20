package calculator;

import calculator.util.UTF8ConsoleWriter;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorUI {

	private static final String INTRO_MSG = "덧셈할 문자열을 입력해 주세요.";
	private static final String RESULT_MSG = "결과 : ";

	private final Calculator calculator;

	public CalculatorUI(Calculator calculator) {
		this.calculator = calculator;
	}

	public void run() {
		String input = readLine();
		int result = calculator.sum(input);
		UTF8ConsoleWriter.println(RESULT_MSG + result);
	}

	private String readLine() {
		UTF8ConsoleWriter.println(INTRO_MSG);
		return Console.readLine();
	}
}
