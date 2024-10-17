package calculator;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("덧셈할 문자열을 입력해 주세요.");
		String input = scanner.nextLine();
		int result = 0;

		String customDelimiter = CustomDelimiter.findDelimiter(input);
		int delmiiterEndIdx = CustomDelimiter.findDelimiterEndIndex(input);
		String[] nums = StringSplit.stringSplit(input, customDelimiter, delmiiterEndIdx);
		for (String num : nums)
		result += Integer.parseInt(num); 
		System.out.println("결과 : " + result);
	}
}
