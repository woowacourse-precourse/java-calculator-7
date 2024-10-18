package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class AdditionCalculatorView implements CalculatorView{

	private static final String INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";
	private static final String OUTPUT_STRING = "결과 : ";

	@Override
	public String input() {
		System.out.println(INPUT_STRING);
		try {
			String input = Console.readLine();
			return input;
		} finally {
			Console.close();
		}
	}

	@Override
	public void output(String result) {
		System.out.println(OUTPUT_STRING + result);
	}
}
