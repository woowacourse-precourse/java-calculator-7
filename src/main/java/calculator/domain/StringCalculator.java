package calculator.domain;

import calculator.utils.SplitString;

public class StringCalculator {
    public int calculateSum(String input) {
        try {
            String[] numbers = SplitString.splitInput(input);
            int sum = 0;

            for (String number : numbers) {
                int parsedNumber = ParseNumber.parseNumber(number);
                sum += parsedNumber;
            }

            return sum;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
