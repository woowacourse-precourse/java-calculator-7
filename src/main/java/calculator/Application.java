package calculator;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
	private static String input;
	private static long result;

	public static void main(String[] args) {
		System.out.println("덧셈할 문자열을 입력해 주세요.");

		input = readLine();

		solution();

		System.out.println("결과 : " + result);
	}
}
