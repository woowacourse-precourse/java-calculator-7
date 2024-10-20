package calculator;

import java.util.regex.Pattern;

public class ParseSplitter {

	public static String[] splitString(String input, String delimiter, int beginIndex) {
		String newString = input;

		if (beginIndex != 0) {
			newString = input.substring(beginIndex);
			delimiter = Pattern.quote(delimiter);
		}
		return newString.split("[" + delimiter + "]"); // 복수의 커스텀 구분자를 분리해서 사용 []
	}

	public static int charToInt(String num) {
		long result = 0;
		int digit;
		char charNum;

		for (int i = 0; i < num.length(); i++) {
			charNum = num.charAt(i);
			if (!Character.isDigit(charNum)) {
				throw new IllegalArgumentException("잘못된 사용자 입력 : " + charNum);
			}
			digit = charNum - '0';
			if (result * 10 + digit > Integer.MAX_VALUE) {
				throw new IllegalArgumentException("INT를 초과하는 값");
			}
			result = result * 10 + (digit);
		}
		return (int) result;
	}
}
