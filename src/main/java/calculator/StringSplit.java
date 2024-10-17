package calculator;

public class StringSplit {
	public static String[] splitString(String input, String delimiter, int beginIndex) {
		String newString = input.substring(beginIndex);
		String[] numbers = newString.split("[" + delimiter + "]"); // //\n 이후의 문자열을 구분자로 나눔
		/*
		 * 24.10.17
		 * 사용자 입력이 //\\n22\23\44 처럼 들어오는 경우 위 ("[" + delimiter + "]") 표현에서 대괄호가 닫히지 않아 문제 발생
		 * split 직접 구현 필요
		 */
		return numbers;
	}
}
