package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
	public String consoleInput () {
		printInput();
		return Console.readLine();
	}

	private void printInput () {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
	}
}
