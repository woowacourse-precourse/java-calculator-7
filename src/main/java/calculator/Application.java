package calculator;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	
	// 2. 입력 받은 문자 분리
    public static String[] splitInput(String inputString) {
        if (inputString.startsWith("//")) {
            // 커스텀 구분자가 있는 경우
            String[] parts = inputString.split("\n", 2);
            String delimiter = parts[0].substring(2); // "//" 이후의 커스텀 구분자 추출
            String numbersPart = parts[1];  // 숫자 부분
            return numbersPart.split(Pattern.quote(delimiter)); // 커스텀 구분자로 분리
        } else {
            // 기본 구분자 쉼표(,) 또는 콜론(:)으로 분리
            return inputString.split("[,:]");
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
                total += Integer.parseInt(num); // 숫자 변환 및 덧셈
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
            String userInput = Console.readLine();
            
            // 2. 입력 받은 문자열을 분리
            String[] numbers = splitInput(userInput);
            
            // 3. 덧셈 계산
            int result = sumNumbers(numbers);
            
            // 4. 결과 출력
            System.out.println("결과: " + result);
    	
    	}catch (IllegalArgumentException e) {
            // 잘못된 입력 처리
            System.out.println(e.getMessage());
        }
    	
    }
}
