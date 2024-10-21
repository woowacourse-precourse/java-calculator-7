package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 입력값 받기
        System.out.println("덧셈할 문자열을 입력하세요.");
        String input = Console.readLine();


        // 결과값 출력 처리
        Calculator calculator = new Calculator();
        try {
            int result = calculator.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
