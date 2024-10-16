package calculator.View;

import calculator.Constants.OutputMessages;

public class OutputView {
    public static void printResultMessage() {
        System.out.print(OutputMessages.RESULT);
    }

    public static void printResult(int result) {
        System.out.println(result);
    }
}
