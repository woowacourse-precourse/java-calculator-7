package calculator;

import camp.nextstep.edu.missionutils.Console;
import delimiter.Delimiter;
import delimiter.base.BaseDelimiter;
import delimiter.custom.CustomDelimiter;

public class CaculatorMachine {

	// 구분자 선언
	String baseDelimiter = BaseDelimiter.COMMA.getDescription() + "|" + BaseDelimiter.COLON.getDescription();

	Delimiter delimiter = Delimiter.of(baseDelimiter);

	public void run() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");

		String userInput = Console.readLine();

		int result = calculate(userInput);
		System.out.println("결과 : " + result);
	}

	public int calculate(String userInput) {

		// 입력 문자열이 공백인 경우
		if (isUserInputNull(userInput)) {
			return 0;
		}

		userInput = delimiter.checkDelimiter(userInput);

		// 구분자를 기준으로 문자열 분리
		if (delimiter.hasDelimiter(userInput, baseDelimiter)) {
			return calculateSum(userInput, baseDelimiter);
		} else {
			// 커스텀 구분자 선언은 존재하나, 사용하지 않은 경우
			return Integer.parseInt(userInput);
		}

	}

	// 문자열이 공백인지 판단
	private boolean isUserInputNull(String userInput) {
		return userInput == null || userInput.isEmpty();
	}

	// 숫자의 합을 계산
	private static int calculateSum(String userInput, String baseDelimiter) {
		String[] numbers = userInput.split(baseDelimiter);
		// 숫자의 합을 저장할 변수
		int sum = 0;
		for (String number : numbers) {
			// 숫자 중간에 공백이 존재하는 경우
			if (number.contains(" ")) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}

			try {
				int num = Integer.parseInt(number);
				// 2. 음수가 입력된 경우
				if (num < 0) {
					throw new IllegalArgumentException("잘못된 입력입니다.");
				}
				sum += num;
				// 1. 정해진 구분자나 숫자가 아닌 다른 문자가 입력된 경우
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}
		}
		return sum;
	}
}
