package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    private static final String READ_NUMBER_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과 : ";

    public static String readInputString() {
        System.out.println(READ_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static void printResult(int result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
