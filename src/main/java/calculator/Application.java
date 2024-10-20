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

	private static void solution() {
		if (input.equals(""))
			return;

		String[] tokens = split(input);

		add(tokens);
	}

	private static String[] split(String input) {
		if (input.startsWith("//")) {
			int enterIndex = input.indexOf("\\n");

			if (enterIndex == -1) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}

			String customDelimiter = input.substring(2, enterIndex);
			String numbers = input.substring(enterIndex + 2);

			// 구분자를 전부 쉼표로 교체
			numbers = numbers.replace(customDelimiter, ",");
			numbers = numbers.replace(":", ",");

			return numbers.split(",");
		}

		return input.split(",|:");
	}

	private static long numberFrom(String token) {
		try {
			long number = Long.parseLong(token);

			if (number <= 0) {
				throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
			}

			return number;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
	}

	private static void add(String[] tokens) {
		long sum = 0;

		for (String token : tokens) {
			sum += numberFrom(token);
		}

		result = sum;
	}
}
