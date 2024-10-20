package calculator.Validator;

import java.util.List;

public final class Validator {

    public static void validateParsedStrings(List<String> parsedStrings) throws IllegalArgumentException {
        for (String str : parsedStrings) {
            if (str.isBlank()) {
                continue;
            }

            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid string input or delimiter");
            }
        }
    }

    public static void validatePositiveNumbers(List<Integer> parsedNumbers) throws IllegalArgumentException {
        for (int number : parsedNumbers) {
            if (number <= 0) {
                throw new IllegalArgumentException("All input numbers must be greater than zero.");
            }
        }
    }
}
