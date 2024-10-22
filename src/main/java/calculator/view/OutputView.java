package calculator.view;

import calculator.view.constants.OutputType;

public class OutputView {
    private OutputView() {
    }

    public static void commonOutputLine(String output) {
        System.out.println(output);
    }

    public static void totalOutputLine(String output) {
        System.out.println(OutputType.RESULT_TYPE.getMessage() + output);
    }
}
