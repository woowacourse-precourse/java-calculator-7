package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            StringCalculator calculator = new StringCalculator();
            System.out.println("덧셈할 문자열을 입력해 주세요. ");
            String input = Console.readLine();
            int result = calculator.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 에러 메시지를 명확하게 출력하고 예외를 던짐
            System.err.println("Error: " + e.getMessage());
            throw e;
        }
    }
}
