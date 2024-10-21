package calculator;

import camp.nextstep.edu.missionutils.Console;
import validator.InputValidator;


public class Application {
    public static void main(String[] args) {
        // 사용자에게 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        String input = Console.readLine();
        try {
            // 올바른 값인지 입력값 검증
            InputValidator.validateInput(input);
            System.out.println("결과 : " + input);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }


    }
}

