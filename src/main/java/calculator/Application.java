package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String ASK_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String CALCULATE_RESULT_MESSAGE = "결과 : %d";

    public static void main(String[] args) {
        final String input;
        final int result;

        System.out.println(ASK_INPUT_MESSAGE);
        input = Console.readLine();

        result = Calculator.calculate(input);
        System.out.printf(CALCULATE_RESULT_MESSAGE, result);
    }
}