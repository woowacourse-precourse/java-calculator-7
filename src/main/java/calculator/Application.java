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
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	// 1. 사용자 입력 받기 (Console API 사용)
        String userInput = Console.readLine();
        
        // 2. 입력 받은 문자열을 분리
        String[] numbers = splitInput(userInput);
    }
}
