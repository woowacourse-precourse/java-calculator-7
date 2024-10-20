package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            
            // 첫 번째 줄: 구분자 설정
            String delimiterInput = Console.readLine();
            // 두 번째 줄: 숫자 입력
            String numbersInput = Console.readLine();
            
            // 두 줄을 합쳐서 Calculator에 전달
            String input = delimiterInput + "\n" + numbersInput;
            
            int result = calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력 값입니다.");
            throw e; // 테스트에서 예외를 감지할 수 있도록 예외 재던지기
        }
    }
}
