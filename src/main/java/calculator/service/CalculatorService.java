package calculator.service;

import calculator.model.Calculator;

public class CalculatorService {
    public int calculate(String input) {
        input = input.replace("\\n", "\n");
        Calculator calculator = new Calculator();

        if (input.isEmpty()) {
            calculator.setNumbers(new int[]{0});
        } else {
            String delimiters = "[,|:]";
            if (input.startsWith("//")) {
                String[] split = input.split("\n", 2);
                String customDelimiter = split[0].substring(2);
                delimiters = "[" + delimiters.substring(1, 4) + "|" + customDelimiter + "]";
                input = split[1];
            }
            String[] splitInput = input.split(delimiters);
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
