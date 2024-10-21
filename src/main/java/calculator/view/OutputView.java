package calculator.view;

import calculator.dto.CalculatorResponse;

public class OutputView {
    public static void viewResult(CalculatorResponse response) {
        System.out.println("결과 : " + response.result());
    }
}
