package calculator.views;

import camp.nextstep.edu.missionutils.Console;

public class calculatorInputView {

    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "결과: ";

    public static String readInput() {
        return Console.readLine();
    }
    private static void displayInputPrompt() {
        System.out.println(INPUT_PROMPT);
    }

    public static void displayResult(long result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
