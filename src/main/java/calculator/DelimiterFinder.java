package calculator;

public class DelimiterFinder {

	public static String findDelimiter(String input) {
		int customPrefixIndex = input.indexOf("//");
		String delimiter = ",:";

		if (customPrefixIndex == 0) {
			input = input.replace("\\n", "\n");
			int customSuffixIndex = input.indexOf('\n');
			// 커스텀 구분자 포맷을 커스텀 구분자로 사용하지 못하게 함
			if (customSuffixIndex == -1 || customPrefixIndex + 2 == customSuffixIndex
				|| input.indexOf("///") == 0) {
				throw new IllegalArgumentException("잘못된 커스텀 구분자 포맷");
			}
			delimiter = input.substring(2, customSuffixIndex);
		}
		return delimiter;
	}

	public static int findDelimiterEndIndex(String input) {
		input = input.replace("\\n", "\n");
		if (input.indexOf("//") == -1) {
			return 0;
		}
		int customSuffixIndex = input.indexOf('\n');
		return customSuffixIndex + 2; // 커스텀 구분자 지정 문자를 뺀 끝 인덱스 반환
	}
}
