package calculator.service;

import calculator.model.Calculator;

public class CalculatorService {
    public int calculate(String input) {
        Calculator calculator = new Calculator();

        if (input.isEmpty()) {
            calculator.setNumbers(new int[]{0});
        } else {
            String[] splitInput = input.split("[,|:]");
            int[] splitNum = new int[splitInput.length];

            for (int i = 0; i < splitInput.length; i++) {
                splitNum[i] = Integer.parseInt(splitInput[i]);
            }
            calculator.setNumbers(splitNum);
        }

        calculator.doSum();
        return calculator.getSum();
    }
}
