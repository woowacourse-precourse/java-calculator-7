package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class AdditionCalculatorView {

	private static final String INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";
	private static final String OUTPUT_STRING = "결과 : %d";



	public String input(){
		System.out.println(INPUT_STRING);
		try{
			String input = Console.readLine();
			return input;
		}
		finally {
			Console.close();
		}
	}

	public void output(long result){
		System.out.printf(OUTPUT_STRING, result);
	}
}
