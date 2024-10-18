package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CaculatorMachine {

	private static final String START_CUSTOMDELIMITER = "//";
	private static final String END_CUSTOMDELIMITER = "\\n";

	public void run() {
		System.out.println("덧셈할 문자열을 입력해 주세요.");

		String userInput = Console.readLine();

		int result = calculate(userInput);
		System.out.println("결과 : " + result);
	}

	public static int calculate(String userInput) {

		// 입력 문자열이 공백인 경우
		if (isUserInputNull(userInput)) {
			return 0;
		}
		// 구분자 선언
		String defaultDelimiter = ",|:";
		String customDelimiter = "";

		// 커스텀 구분자
		// 5-2. "\n"만 존재하는 경우
		if (hasEndDelimiter(userInput)) {
			if (hasNotStartDelimiter(userInput)) {
				throw new IllegalArgumentException("질못된 입력입니다.");
			}
		}

		// 5-3. "\n"이 "//"보다 더 앞에 있는 경우
		if (isEndDelimiterBeforStartDelimiter(userInput)) {
			throw new IllegalArgumentException("질못된 입력입니다.");
		}

		// 5-5. "//"와 "\n"이 문자열 맨 앞에 존재하지 않는 경우
		if (hasStartDelimiter(userInput) && hasEndDelimiter(userInput)) {
			if (isNotStartWithStartDelimiter(userInput)) {
				throw new IllegalArgumentException("질못된 입력입니다.");
			}
		}

		if (isStartWithStartDelimiter(userInput)) {
			// 5-6. "//"가 2번 이상 존재하는 경우
			if (hasTwoStartDelimiter(userInput)) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}

			// 5-1. "//"만 존재하는 경우
			if (hasNotEndDelimiter(userInput)) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}

            int delimiterEndIndex = userInput.indexOf(END_CUSTOMDELIMITER);
			// 5-7. "\n"이 2번 이상 존재하는 경우
			if (hasTwoEndDelimiter(userInput, delimiterEndIndex)) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}

			customDelimiter = userInput.substring(2, delimiterEndIndex);
			// 5-4. 커스텀 구분자가 1개가 아닌 경우
			if (hasMultipleCustomDelimiters(customDelimiter)) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}

			defaultDelimiter = defaultDelimiter + "|" + customDelimiter;

			// 커스텀 구분자 생성하는 부분 제외한 입력 부분 추출
			userInput = userInput.substring(delimiterEndIndex + 2);

		}

		// 4. 문자열이 구분자로 시작하거나 끝나는 경우
		if (startsOrEndsWithDelimiter(userInput, defaultDelimiter)) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
		// 3. 구분자가 연속으로 2번 이상 나온 경우
		if (containsRepeatedDelimiters(userInput) || containsRepeatedCustomDelimiters(userInput, customDelimiter)) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}

		// 구분자를 기준으로 문자열 분리
		if (hasDelimiter(userInput, defaultDelimiter)) {
			return caculateSum(userInput, defaultDelimiter);
		} else {
			// 커스텀 구분자 선언은 존재하나, 사용하지 않은 경우
			return Integer.parseInt(userInput);
		}

	}

	// 숫자의 합을 계산
	private static int caculateSum(String userInput, String defaultDelimiter) {
		String[] numbers = userInput.split(defaultDelimiter);
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

	// 구분자를 가지고 있을 때
    private static boolean hasDelimiter(String userInput, String defaultDelimiter) {
        return userInput.contains(defaultDelimiter);
    }

    // 커스텀 구분자가 2번 이상 나오는 경우
    private static boolean containsRepeatedCustomDelimiters(String userInput, String customDelimiter) {
        return !customDelimiter.isEmpty() && userInput.contains(customDelimiter + customDelimiter);
    }

    // 기본 구분자가 2번 이상 나오는 경우
    private static boolean containsRepeatedDelimiters(String userInput) {
        return userInput.contains(",,") || userInput.contains("::") || userInput.contains(",:") || userInput.contains(
            ":,");
    }

    // 구분자로 시작하거나 끝날 경우
    private static boolean startsOrEndsWithDelimiter(String userInput, String defaultDelimiter) {
        return userInput.startsWith(defaultDelimiter) || userInput.endsWith(defaultDelimiter);
    }

    // 커스텀 구분자가 1개 이상일 때
    private static boolean hasMultipleCustomDelimiters(String customDelimiter) {
        return customDelimiter.length() != 1;
    }

    // "\n"이 2번 이상 존재할 때
    private static boolean hasTwoEndDelimiter(String userInput, int delimiterEndIndex) {
        return userInput.indexOf(END_CUSTOMDELIMITER, delimiterEndIndex + 1) != -1;
    }

    // "//"가 2번 이상 존재할 때
	private static boolean hasTwoStartDelimiter(String userInput) {
		return userInput.indexOf(START_CUSTOMDELIMITER, 2) != -1;
	}

	// "//"로 시작할 때
	private static boolean isStartWithStartDelimiter(String userInput) {
		return userInput.startsWith(START_CUSTOMDELIMITER);
	}

	// "//"로 시작하지 않을 때
	private static boolean isNotStartWithStartDelimiter(String userInput) {
		return !isStartWithStartDelimiter(userInput);
	}

	// "//"를 갖고 있을 때
	private static boolean hasStartDelimiter(String userInput) {
		return userInput.contains(START_CUSTOMDELIMITER);
	}

	// "\n"을 갖고 있을 때
	private static boolean hasEndDelimiter(String userInput) {
		return userInput.contains(END_CUSTOMDELIMITER);
	}

    // "\n"을 갖고 있지 않을 때
    private static boolean hasNotEndDelimiter(String userInput) {
        return !hasEndDelimiter(userInput);
    }

	// "//"를 갖고 있지 않을 때
	private static boolean hasNotStartDelimiter(String userInput) {
		return !hasStartDelimiter(userInput);
	}

	// "\n"이 "//"보다 더 앞에 있는지 판단
	private static boolean isEndDelimiterBeforStartDelimiter(String userInput) {
		return userInput.indexOf(END_CUSTOMDELIMITER) < userInput.indexOf(START_CUSTOMDELIMITER);
	}

	// 문자열이 공백인지 판단
	private static boolean isUserInputNull(String userInput) {
		return userInput == null || userInput.isEmpty();
	}

}
