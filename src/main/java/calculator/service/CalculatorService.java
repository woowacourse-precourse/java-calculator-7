package calculator.service;

import calculator.view.CalculatorView;

public class CalculatorService {

    public Boolean checkZero(String input) {
        if (input == null || input.isEmpty()) {
            CalculatorView.printResult(0);
            return true;
        }
        return false;
    }


}
