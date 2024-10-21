package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            Calculator calculator = new Calculator();
            int sum = calculator.calculate(input);

            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e; // 에러 던지기
        }
    }
}
