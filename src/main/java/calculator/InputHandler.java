package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
	public String getInput() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String input = Console.readLine();
		validateIsInputEmpty(input);

		return input;
	}

	public void validateIsInputEmpty(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("올바르지 않은 입력값 입니다.");
		}
	}
}
