package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        DelimiterParser delimiterParser = new DelimiterParser();
        StringCalculator stringCalculator = new StringCalculator(delimiterParser);
        int result = stringCalculator.add(input);
        print(result);
    }

    private static void print(int result) {
        System.out.println("결과 : " + result);
    }
}
