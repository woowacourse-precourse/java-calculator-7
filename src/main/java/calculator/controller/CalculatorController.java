package calculator.controller;

import calculator.model.Calculator;

public class CalculatorController {
    private final Calculator calculator = new Calculator();

    public void startCalculator() {

    }

    private String[] extractNumbers(String input) {
        String delimiter = "[,:]";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("/n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        return input.split(delimiter);
    }

    private int[] toPositiveNumberArray(String[] extractNumbers) {
        int[] numberArray = new int[extractNumbers.length];
        for (int count = 0; count < extractNumbers.length; count++) {
            numberArray[count] = verifyPositive(extractNumbers[count]);
        }

        return numberArray;
    }

    private int verifyPositive(String extractNumber) {
        int number = Integer.parseInt(extractNumber);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력될 수 없습니다.");
        }

        return number;
    }
}
