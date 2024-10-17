package calculator.service;

import calculator.util.SeparatorUtils;

public class CalculatorService {

    public int calculate(String input) {
        String operand = SeparatorUtils.parseSeparators(input);
        String operation = String.join("", SeparatorUtils.getSeparators());

        return operation(operand, operation);
    }

    private int operation(String operand, String operation) {
        return 0;
    }
}
