package calculator.service;

import calculator.model.CalculatorModel;

public class CalculatorService {
    private final CalculatorModel calcModel;

    public CalculatorService() {
        this.calcModel = new CalculatorModel();
    }


    public int caculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return 0;
    }
}
