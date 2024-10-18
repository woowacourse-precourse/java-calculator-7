package calculator.view;

import java.math.BigInteger;

public class OutputView {

    private static final String ASK_INPUT_STRING = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT = "결과 : %,d";

    public void printAskInputString() {
        printMessage(ASK_INPUT_STRING);
    }

    public void printResult(final BigInteger result) {
        printMessage(String.format(RESULT, result));
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
