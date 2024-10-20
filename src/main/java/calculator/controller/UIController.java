package calculator.controller;

import calculator.domain.number.Number;
import calculator.view.InputView;
import calculator.view.OutputView;

public class UIController {
    private static final String SUM_STRING_INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_FORMAT = "결과 : ";

    public static String receive() {
        OutputView.print(SUM_STRING_INPUT_MESSAGE);
        return InputView.readValue();
    }

    public static void printError(String message) {
        OutputView.print(message);
    }

    public static void printSumResult(Number number) {
        OutputView.print(fitFormat(number));
    }

    private static String fitFormat(Number number) {
        return RESULT_FORMAT + number.getValue();
    }
}
