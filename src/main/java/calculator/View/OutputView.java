package calculator.View;

import calculator.Constants.OutputMessages;
import calculator.Utils.NumberUtils;

public class OutputView {
    OutputView() {
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
