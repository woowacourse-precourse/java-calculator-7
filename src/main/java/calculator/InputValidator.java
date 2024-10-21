package calculator;

import java.util.Arrays;

public class InputValidator {
    public void validate(String[] numbers) {
        Arrays.stream(numbers).forEach(number -> {
            try {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber < 0) {
                    throw new IllegalArgumentException("Negative numbers are not allowed.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number format.");
            }
        });
    }
}