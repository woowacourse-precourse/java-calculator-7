package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int sum = Calculator.inputCalculator(input);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }
}
