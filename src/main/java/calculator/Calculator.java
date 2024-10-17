package calculator;

public class Calculator {
	public static void calculator(String input){
		if (input == null || input == ""){
			throw new IllegalArgumentException("빈 사용자 입력"); 
		}
		String customDelimiter = CustomDelimiter.findDelimiter(input);
		int delmiiterEndIdx = CustomDelimiter.findDelimiterEndIndex(input);
		String[] numbers = StringSplit.splitString(input, customDelimiter, delmiiterEndIdx);
		long result = 0;

		for (String num : numbers){
			result += ConvertInt.convertInt(num);
		}
		System.out.println("결과 : " + result);
	}
}
