package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
	private static final String ENTER_SENTENCE_TO_ADD = "덧셈할 문자열을 입력해 주세요.";

	public String getInput(){
		System.out.println(ENTER_SENTENCE_TO_ADD);
		return Console.readLine();
	}

	public void printOutput(Long result) {
		System.out.println("결과 : " + result);
	}
}
