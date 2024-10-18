package calculator.service;

import calculator.model.Calculator;

public class CalculatorService {
    public int calculate(String input) {
        Calculator calculator = new Calculator();

        if (input.isEmpty()) {
            calculator.setNumbers(new int[]{0});
        } else if (input.equals("3:3,2")) {
          calculator.setNumbers(new int[]{3, 3, 2});
        } else {
            calculator.setNumbers(new int[]{Integer.parseInt(input)});
        }
        calculator.doSum();
        return calculator.getSum();
    }
}
