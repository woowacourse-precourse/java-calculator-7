package calculator;

public class Calculator {
	public static final int MAX_INT = 2147483647;

	public static void calculator(String input){
		if (input == null || input == ""){
			throw new IllegalArgumentException("빈 사용자 입력"); 
		}
		String customDelimiter = CustomDelimiter.findDelimiter(input);
		int delmiiterEndIdx = CustomDelimiter.findDelimiterEndIndex(input);
		String[] numbers = StringSplit.splitString(input, customDelimiter, delmiiterEndIdx);
		long result = 0;

		for (String num : numbers){
			if (result + ConvertInt.convertInt(num) > MAX_INT){
				throw new IllegalArgumentException("INT 초과 합");
			}
			result += ConvertInt.convertInt(num);
		}
		System.out.println("결과 : " + result);
	}
}
