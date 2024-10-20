package calculator.view;

import calculator.model.Calculator;

public class OutputView {
    private static final String PRINT_RESULT_START_MSG = "결과 : ";

    public void outputResult(Calculator calculator) {
        System.out.println(PRINT_RESULT_START_MSG + calculator.getSum());
    }
}
