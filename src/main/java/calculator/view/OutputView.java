package calculator.view;

import static calculator.util.Messages.PRINT_RESULT_START_MSG;

import calculator.model.Calculator;

public class OutputView {
    public void outputResult(Calculator calculator) {
        System.out.println(PRINT_RESULT_START_MSG + calculator.getSum());
    }
}
