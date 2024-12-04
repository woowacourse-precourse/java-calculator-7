package calculator.service;

import calculator.domain.CalculatorInput;

public class CalculatorService {
    private String delimiters = ",:";

    public int calculate(CalculatorInput calculatorInput) {
        String input = calculatorInput.getInput();
        addDelimiter(input);
        return computeSum(input);
    }

    private void addDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd != -1) {
                String customDelimiter = input.substring(2, delimiterEnd);
                delimiters += customDelimiter;
                // Update input to exclude custom delimiter declaration
                input = input.substring(delimiterEnd + 2);
            } else {
                throw new IllegalArgumentException("Wrong input format.");
            }
        }
    }

    private int computeSum(String input) {
        String[] tokens = input.split("[" + delimiters + "]");
        int sum = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = parseNumber(token);
                sum += num;
            }
        }
        return sum;
    }

    private int parseNumber(String token) {
        int num = Integer.parseInt(token);
        if (num < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        return num;
    }
}
