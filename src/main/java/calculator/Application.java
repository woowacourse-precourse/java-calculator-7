package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	// 사용자에게 문자열 입력을 받음
    	System.out.println("문자열을 입력하세요.");
    	
    	// Console 라이브러리를 사용하여 입력을 받음
    	String input = Console.readLine();
    	
    	try {
    		int result = StringAddCalculator.add(input);
    		System.out.println("계산 결과: " + result);
    	} catch (IllegalArgumentException e) {
    		System.out.println(e.getMessage());
    	}
    }
}
