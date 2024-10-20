package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("문자열을 입력하세요.");
        String input = Console.readLine();

        try {
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException("입력값이 없습니다.");
            }

            StringCalculator calculator = new StringCalculator();
            int result = calculator.calculate(input);

            System.out.println("결과 : " + result);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
