package calculator.view;

import static calculator.constant.ViewConstants.INPUT_STRING;
import static calculator.constant.ViewConstants.RESULT;

public class OutputView {
    public static void printInputPrompt() {
        System.out.println(INPUT_STRING);
    }

    public static void printResult(Number number) {
        System.out.println(RESULT + number);
    }
}
