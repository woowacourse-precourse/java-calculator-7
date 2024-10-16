package calculator.view;

import calculator.domain.Number;

public class OutputView {
    private static final String RESULT_MESSAGE = "결과 : %s";

    static public void printResult(String result) {
        System.out.printf(RESULT_MESSAGE, result);
    }
}

