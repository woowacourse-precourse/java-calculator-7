package calculator.domain;

import calculator.util.InputParser;
import calculator.util.Validator;

public class StringCalculator {
    String delimiterPart;
    String numbersPart;

    public int calculate(String input) {
        if (Validator.isEmpty(input)) {
            return 0;
        }
        String[] stringParts = input.split("n", 2);
        if (stringParts.length > 1) {
            this.delimiterPart = stringParts[0];
            this.numbersPart = stringParts[1];
        } else {
            this.delimiterPart = stringParts[0];
            this.numbersPart = delimiterPart;
        }

        String delimiter = InputParser.getDelimiter(delimiterPart);
        String[] numbers = numbersPart.split(delimiter);

        return sum(numbers);

    }

    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim()); // string to integer

            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            total += num;
        }
        return total;
    }
}
