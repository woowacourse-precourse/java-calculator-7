package calculator.view;

import calculator.config.ViewConstants;

public class OutputView {
    public void printResult(int result) {
        System.out.println(ViewConstants.RESULT_LABEL + result);
    }
}
