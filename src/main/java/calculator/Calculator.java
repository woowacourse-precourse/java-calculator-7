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
			result += convertInt(num);
		}
		System.out.println("결과 : " + result);
	}

	private static String findDelimiter(String input) {
		if (input == null || input.isEmpty()){
			throw new IllegalArgumentException("비어있는 사용자 입력");
		}
		String delimiter = ",|:";

		if (input.startsWith("//")){
			input = input.replace("\\n", "\n");
			int	endIndex = input.indexOf('\n');
			if (endIndex == -1){
				throw new IllegalArgumentException("잘못된 커스텀 구분자 포맷");
			}
			delimiter = input.substring(2, endIndex);
		}
		return delimiter;
	}

	private static int findDelimiterEndIndex(String input) {
		input = input.replace("\\n", "\n");
		if (input.indexOf("//") == -1){
			return 0;
		}
		int endIndex = input.indexOf('\n');
		return endIndex + 2; // 커스텀 구분자 지정 문자를 뺀 끝 인덱스 반환
	}

	public static String[] splitString(String input, String delimiter, int beginIndex) {
		String newString = input;
		if (beginIndex != 0) {
			newString = input.substring(beginIndex);
			delimiter = Pattern.quote(delimiter); // 커스텀 구분자일 때 (주석 추가 설명 필요)
		}
		return newString.split(delimiter);
	}

	public static int convertInt(String num)
	{
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
