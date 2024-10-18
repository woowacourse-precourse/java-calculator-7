package calculator.service;

import calculator.model.Calculator;

public class CalculatorService {
    public int calculate(String input) {
        Calculator calculator = new Calculator();

        if (input.isEmpty()) {
            calculator.setNumbers(new int[]{0});
        } else {
            calculator.setNumbers(new int[]{Integer.parseInt(input)});
        }
        calculator.doSum();
        return calculator.getSum();
    }
}
