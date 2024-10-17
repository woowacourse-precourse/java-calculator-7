package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        StringCalculator calculator = new StringCalculator();
        try {
            int result = calculator.add(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("입력한 값에 문제가 있습니다. " + e.getMessage());
        }

    }
}
