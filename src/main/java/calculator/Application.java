package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        StringCalculator calculator = new StringCalculator(new StringExtractor(), new NumberParser());
        int result = calculator.sum(input);
        System.out.println("결과 : " + result);
    }
}
