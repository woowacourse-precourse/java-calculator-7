package calculator.view;

import static calculator.config.SystemConstantMessages.CALCULATOR_START_MESSAGE;
import static calculator.config.SystemConstantMessages.RESULT_MESSAGE;
import static calculator.config.SystemConstantMessages.VIEW_CLASS_MESSAGE;

public class OutputView {
    private OutputView() {
        throw new IllegalStateException(VIEW_CLASS_MESSAGE);
    }

    public static void printStartMessage() {
        System.out.println(CALCULATOR_START_MESSAGE);
    }

    public static void printResult(Integer result) {
        System.out.println(RESULT_MESSAGE + result);
    }
}
