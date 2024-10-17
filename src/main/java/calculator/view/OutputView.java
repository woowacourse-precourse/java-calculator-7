package calculator.view;

import calculator.dto.response.CalculatorResponse;

public class OutputView {
    public static void printResult(CalculatorResponse response) {
        System.out.printf(ViewMessages.RESULT_MESSAGE + response.result());
    }
}
