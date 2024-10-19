package calculator.view;

import calculator.entity.CalculationResult;

public class OutputView {

    public void displayResult(CalculationResult result) {
        System.out.println(result);
    }

    public void displayError(String message) {
        System.out.println(message);
    }
}
