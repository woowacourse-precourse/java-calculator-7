package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try {
            String input = Console.readLine();
            input = input.replace("\\n", "\n");

            StringCalculator calculator = new StringCalculator();
            int result = calculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("잘못된 입력입니다: " + e.getMessage());
        }
    }
}
