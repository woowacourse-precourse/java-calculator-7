package calculator;

public class StringSplit {
	public static String[] splitString(String input, String delimiter, int beginIndex) {
		if (delimiter.indexOf("\\") != -1){
			throw new IllegalArgumentException("틀린 커스텀 구분자 포맷");
		}
		String newString = input.substring(beginIndex);
		String[] numbers = newString.split("[" + delimiter + "]"); // //\n 이후의 문자열을 구분자로 나눔
		return numbers;
	}
}
