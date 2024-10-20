package calculator.view;

import calculator.constants.OutputMessages;
import calculator.utils.NumberUtils;

public class OutputView {
    private OutputView() {
    }

    public static void printResultMessage() {
        System.out.print(OutputMessages.RESULT);
    }

    public static void printResult(Double result) {
        if (NumberUtils.isInt(result)) {
            System.out.println((long) (double) result);
        }

        if (!NumberUtils.isInt(result)) {
            System.out.println(result);
        }
    }
}
