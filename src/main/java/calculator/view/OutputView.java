package calculator.view;

import calculator.domain.Calculator;

public class OutputView {

    private static final String RESULT_MSG = "결과 : ";

    public void outputResult(Calculator calculator) {
        System.out.println(RESULT_MSG + calculator.getSumNumbers());
    }
}
