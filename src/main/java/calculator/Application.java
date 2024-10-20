package calculator;

import camp.nextstep.edu.missionutils.Console;
import calculator.controller.StringAddCalculator;

public class Application {
    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        try {
            int result = stringAddCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
