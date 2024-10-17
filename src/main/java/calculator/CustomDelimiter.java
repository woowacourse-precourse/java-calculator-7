package calculator;

public class CustomDelimiter {
	public static String findDelimiter(String input) {
		String defaultDelimiter = ",:";
		int beginIndex = input.indexOf("//");
		int endIndex = input.indexOf("\\n");
		int errIndex = input.indexOf("///");

		if (beginIndex == -1) {
			return defaultDelimiter;
		}
		if (beginIndex != 0 || endIndex == -1 || errIndex == 0) { // 커스텀 구분자를 위한 포맷이 지켜지지 않았을 때
			throw new IllegalArgumentException("틀린 커스텀 구분자 포맷");
		}
		if (beginIndex + 2 == endIndex){
			throw new IllegalArgumentException("빈 커스텀 구분자");
		}
		return input.substring(beginIndex + 2, endIndex);
	}

	public static int findDelimiterEndIndex(String input) {
		int endIndex = input.indexOf("\\n");
		return endIndex + 2; // 커스텀 구분자 지정 문자를 뺀 끝 인덱스 반환
	}
}
