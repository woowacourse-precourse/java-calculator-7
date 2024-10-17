package calculator.View;

import calculator.Constants.OutputMessages;

public class OutputView {
    public static void printResultMessage() {
        System.out.print(OutputMessages.RESULT);
    }

    public static void printResult(Double result) {
        System.out.println(result);
    }
}
