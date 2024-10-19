package calculator;

import camp.nextstep.edu.missionutils.Console;

public class IOController {

	/**
	 * 입력
	 *
	 * @return : 입력받은 문자열
	 */
	public String enter() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String inputStr = Console.readLine();
		Console.close();
		return inputStr;
	}
}
