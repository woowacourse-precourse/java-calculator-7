package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	
	 // 2. 문자열 분리 로직
    public static String[] splitInput(String inputString) {
        // 빈 문자열 처리
        if (inputString == null || inputString.isEmpty()) {
            return new String[0]; // 빈 배열 반환
        }

        // 커스텀 구분자 여부 확인
        if (inputString.startsWith("//")) {
            // 구분자는 "//" 뒤에 오는 첫 문자
            char delimiter = inputString.charAt(2);  // "//" 뒤의 첫 문자를 구분자로 사용
            // 숫자 부분은 "//"와 구분자 뒤의 문자열
            String numbersPart = inputString.substring(5);  // 구분자 이후의 숫자 부분 (5번째 문자부터)
            // 구분자와 기본 구분자인 쉼표(,)와 콜론(:)을 함께 처리
            return numbersPart.split(Pattern.quote(String.valueOf(delimiter)) + "|[,:]");  // 구분자로 분리
        } else {
            // 기본 구분자 쉼표(,) 또는 콜론(:)으로 분리
            return inputString.split("[,:]");  // 쉼표(,)와 콜론(:)으로 분리
        }
    }
    
    // 3. 덧셈 계산
    public static int sumNumbers(String[] numbers) {
        int total = 0;
        for (String num : numbers) {
            if (num.trim().isEmpty()) {
                continue;  // 빈 문자열 무시
            }
            try {
                total += Integer.parseInt(num); // 숫자 변환 후 덧셈
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력값이 있습니다.");  // 숫자가 아닌 경우 예외 처리
            }
        }
        return total;
    }
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	try {
    		// 1. 사용자 입력 받기 (Console API 사용)
//    		System.out.println("//;\n1;2;3");
    		System.out.println("덧셈할 문자열을 입력해 주세요.");
            String userInput = Console.readLine();
            
            // 2. 입력 받은 문자열을 분리
            String[] numbers = splitInput(userInput);
            
            // 3. 덧셈 계산
            int result = sumNumbers(numbers);
            
            // 4. 결과 출력
            System.out.println("결과 : " + result);
    	
    	}catch (IllegalArgumentException e) {
            // 잘못된 입력 처리
            System.out.println(e.getMessage());
        }
    	
    }
}

