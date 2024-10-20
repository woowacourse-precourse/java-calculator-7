package calculator.domain;

import calculator.utils.SplitString;

public class StringCalculator {
    public int calculateSum(String input) {
        String[] numbers = SplitString.splitInput(input);
        int sum = 0;

        for (String number : numbers) {
            int parsedNumber = ParseNumber.parseNumber(number);
            sum += parsedNumber;
        }

        return sum;
    }
}
