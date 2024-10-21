package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public StringCalculator() {

	}

	// 문자열을 입력 받아서 합계를 반환하는 메서드
	public int add(String input) {
		// 빈 문자열 또는 null 체크
		if (input == null || input.isEmpty()) {
			return 0;
		}

		// 커스텀 구분자 정의 여부 확인
		if (input.startsWith("//")) {
			return handleCustomDelimiter(input);
		} else {
			// 기본 구분자를 사용한 문자열 처리
			return handleDefaultDelimiter(input);
		}
	}

	// 커스텀 구분자를 처리하는 메서드
	private int handleCustomDelimiter(String input) {
		// 커스텀 구분자가 올바르게 정의되었는지 확인
		Pattern pattern = Pattern.compile("//(.)\\\\n(.*)|//(.)\n(.*)");
		Matcher matcher = pattern.matcher(input);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("잘못된 커스텀 구분자 정의입니다.");
		}

		String delimiter;
		String numbers;

		if (matcher.group(1) != null) {
			delimiter = matcher.group(1); // 이스케이프된 \\n 처리
			numbers = matcher.group(2);
		} else {
			delimiter = matcher.group(3); // 실제 \n 처리
			numbers = matcher.group(4);
		}

		// 커스텀 구분자가 들어가야 할 위치에 숫자가 있는 경우 처리
		if (!numbers.matches("^[0-9" + Pattern.quote(delimiter) + "]+$")) {
			throw new IllegalArgumentException("구분자 위치에 숫자가 들어갔습니다.");
		}

		// 여러 개의 구분자가 연속으로 사용된 경우 처리
		if (numbers.contains(delimiter + delimiter)) {
			throw new IllegalArgumentException("연속된 구분자가 사용되었습니다.");
		}

		// 구분자가 맨 앞이나 맨 뒤에 있는 경우 처리
		if (numbers.startsWith(delimiter) || numbers.endsWith(delimiter)) {
			throw new IllegalArgumentException("구분자가 맨 앞이나 맨 뒤에 위치할 수 없습니다.");
		}


		// 커스텀 구분자로 문자열을 분리하고 합계 계산
		String[] tokens = numbers.split(Pattern.quote(delimiter));
		return sumTokens(tokens);
	}

	// 기본 구분자 쉼표(,)와 콜론(:)을 처리하는 메서드
	private int handleDefaultDelimiter(String input) {
		// 5. 여러 개의 쉼표나 콜론이 연속으로 사용된 경우 처리
		if (input.contains(",,") || input.contains("::") || input.contains(",:") || input.contains(":,")) {
			throw new IllegalArgumentException("연속된 구분자가 사용되었습니다.");
		}

		// 6. 구분자가 맨 앞이나 맨 뒤에 있는지 처리
		if (input.startsWith(",") || input.startsWith(":") || input.endsWith(",") || input.endsWith(":")) {
			throw new IllegalArgumentException("구분자가 맨 앞이나 맨 뒤에 위치할 수 없습니다.");
		}

		// 쉼표 또는 콜론으로 나누기
		String[] tokens = input.split("[,:]");
		return sumTokens(tokens);
	}

	// 문자열 배열을 숫자로 변환한 후 합계를 계산하는 메서드
	private int sumTokens(String[] tokens) {
		int sum = 0;
		for (String token : tokens) {
			int num = Integer.parseInt(token);

			// 음수 값을 체크하여 예외 발생
			if (num < 0) {
				throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
			}

			sum += num;
		}
		return sum;
	}

}