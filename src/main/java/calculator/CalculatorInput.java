package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorInput {
    private static final String WELCOME_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    private CalculatorInput() {
    }

    public static String getString() {
        System.out.println(WELCOME_MESSAGE);
        return Console.readLine();
    }
}
