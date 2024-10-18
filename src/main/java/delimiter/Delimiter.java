package delimiter;

import delimiter.custom.CustomDelimiter;

public class Delimiter {

	private final String baseDelimiter;
	String customDelimiter = "";
	String delimiters = "";

	private Delimiter(String baseDelimiter) {
		this.baseDelimiter = baseDelimiter;
	}

	public static Delimiter of(String baseDelimiter){
		return new Delimiter(baseDelimiter);
	}

	public String checkDelimiter(String userInput) {
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

			int delimiterEndIndex = userInput.indexOf(CustomDelimiter.END.getDescripton());
			// 5-7. "\n"이 2번 이상 존재하는 경우
			if (hasTwoEndDelimiter(userInput, delimiterEndIndex)) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}

			customDelimiter = userInput.substring(2, delimiterEndIndex);
			// 5-4. 커스텀 구분자가 1개가 아닌 경우
			if (hasMultipleCustomDelimiters(customDelimiter)) {
				throw new IllegalArgumentException("잘못된 입력입니다.");
			}

			delimiters = baseDelimiter + "|" + customDelimiter;

			// 커스텀 구분자 생성하는 부분 제외한 입력 부분 추출
			userInput = userInput.substring(delimiterEndIndex + 2);

		}

		// 4. 문자열이 구분자로 시작하거나 끝나는 경우
		if (startsOrEndsWithDelimiter(userInput, delimiters)) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
		// 3. 구분자가 연속으로 2번 이상 나온 경우
		if (containsRepeatedDelimiters(userInput) || containsRepeatedCustomDelimiters(userInput, customDelimiter)) {
			throw new IllegalArgumentException("잘못된 입력입니다.");
		}
		return userInput;
	}

	// 구분자를 가지고 있을 때
	public boolean hasDelimiter(String userInput, String baseDelimiter) {
		return userInput.contains(baseDelimiter);
	}

	// 기본 구분자가 2번 이상 나오는 경우
	private boolean containsRepeatedDelimiters(String userInput) {
		return userInput.contains(",,") || userInput.contains("::") || userInput.contains(",:") || userInput.contains(
			":,");
	}

	// 구분자로 시작하거나 끝날 경우
	private boolean startsOrEndsWithDelimiter(String userInput, String baseDelimiter) {
		return userInput.startsWith(baseDelimiter) || userInput.endsWith(baseDelimiter);
	}

	// 커스텀 구분자가 2번 이상 나오는 경우
	private boolean containsRepeatedCustomDelimiters(String userInput, String customDelimiter) {
		return !customDelimiter.isEmpty() && userInput.contains(customDelimiter + customDelimiter);
	}

	// 커스텀 구분자가 1개 이상일 때
	private boolean hasMultipleCustomDelimiters(String customDelimiter) {
		return customDelimiter.length() != 1;
	}

	// "\n"이 2번 이상 존재할 때
	private boolean hasTwoEndDelimiter(String userInput, int delimiterEndIndex) {
		return userInput.indexOf(CustomDelimiter.END.getDescripton(), delimiterEndIndex + 1) != -1;
	}

	// "//"가 2번 이상 존재할 때
	private boolean hasTwoStartDelimiter(String userInput) {
		return userInput.indexOf(CustomDelimiter.START.getDescripton(), 2) != -1;
	}

	// "//"로 시작할 때
	private boolean isStartWithStartDelimiter(String userInput) {
		return userInput.startsWith(CustomDelimiter.START.getDescripton());
	}

	// "//"로 시작하지 않을 때
	private boolean isNotStartWithStartDelimiter(String userInput) {
		return !isStartWithStartDelimiter(userInput);
	}

	// "//"를 갖고 있을 때
	private boolean hasStartDelimiter(String userInput) {
		return userInput.contains(CustomDelimiter.START.getDescripton());
	}

	// "\n"을 갖고 있을 때
	private boolean hasEndDelimiter(String userInput) {
		return userInput.contains(CustomDelimiter.END.getDescripton());
	}

	// "\n"을 갖고 있지 않을 때
	private boolean hasNotEndDelimiter(String userInput) {
		return !hasEndDelimiter(userInput);
	}

	// "//"를 갖고 있지 않을 때
	private boolean hasNotStartDelimiter(String userInput) {
		return !hasStartDelimiter(userInput);
	}

	// "\n"이 "//"보다 더 앞에 있는지 판단
	private boolean isEndDelimiterBeforStartDelimiter(String userInput) {
		return userInput.indexOf(CustomDelimiter.END.getDescripton()) < userInput.indexOf(CustomDelimiter.START.getDescripton());
	}
}
