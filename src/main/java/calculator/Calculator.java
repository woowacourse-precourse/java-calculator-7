package calculator;

import java.util.regex.Pattern;

public class Calculator {
	public static void calculate(String input){
		if (input == null || input.isEmpty()){
			throw new IllegalArgumentException("빈 사용자 입력"); 
		}
		String customDelimiter = findDelimiter(input);
		int delmiiterEndIdx = findDelimiterEndIndex(input);
		String[] numbers = splitString(input, customDelimiter, delmiiterEndIdx);
		long result = 0;
		for (String num : numbers){
			result += atoi(num);
		}
		System.out.println("결과 : " + result);
	}

	private static String findDelimiter(String input) {
		if (input == null || input.isEmpty()){
			throw new IllegalArgumentException("비어있는 사용자 입력");
		}
		int customPrefixIndex = input.indexOf("//");
		String delimiter = ",:";

		if (customPrefixIndex == 0) {
			input = input.replace("\\n", "\n");
			int	customSuffixIndex = input.indexOf('\n');
			// 커스텀 구분자 포맷을 커스텀 구분자로 사용하지 못하게 함
			if (customSuffixIndex == -1 || customPrefixIndex + 2 == customSuffixIndex || input.indexOf("///") == 0) {
				throw new IllegalArgumentException("잘못된 커스텀 구분자 포맷");
			}
			delimiter = input.substring(2, customSuffixIndex);
		}
		return delimiter;
	}

	private static int findDelimiterEndIndex(String input) {
		input = input.replace("\\n", "\n");
		if (input.indexOf("//") == -1){
			return 0;
		}
		int customSuffixIndex = input.indexOf('\n');
		return customSuffixIndex + 2; // 커스텀 구분자 지정 문자를 뺀 끝 인덱스 반환
	}

	public static String[] splitString(String input, String delimiter, int beginIndex) {
		String newString = input;

		if (beginIndex != 0) {
			newString = input.substring(beginIndex);
			delimiter = Pattern.quote(delimiter);
		}
		return newString.split("[" + delimiter + "]"); // 복수의 커스텀 구분자를 분리해서 사용 []
	}

	public static int atoi(String num) {
		long	result = 0;
		int		digit;
		char	charNum;

		for (int i = 0; i < num.length(); i++) {
			charNum = num.charAt(i);
			if (!Character.isDigit(charNum)){
				throw new IllegalArgumentException("잘못된 사용자 입력 : " + charNum);
			}
			digit = charNum - '0';
			result = result * 10 + (digit);
		}
		return (int)result;
	}
}
