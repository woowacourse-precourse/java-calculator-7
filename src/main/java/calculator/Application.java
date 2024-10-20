package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // input
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String string = Console.readLine();

        // dependencies
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();

        // StringCalculator
        StringCalculator calculator = new StringCalculator(delimiterExtractor);
        long sum = calculator.calculate(string);

        // output
        System.out.println("결과 : " + sum);
    }
}
