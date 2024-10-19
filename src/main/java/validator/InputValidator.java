package validator;

import exception.InvalidInputException;

import java.util.Arrays;

public class InputValidator {

    public void validate(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        String[] numbers = input.split(",|:");

        // 스트림을 사용하여 유효성 검사
        Arrays.stream(numbers).forEach(number -> {
            try {
                int parsedNumber = Integer.parseInt(number);
                if (parsedNumber < 0) {
                    throw new InvalidInputException("Negative numbers are not allowed.");
                }
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Invalid number format.");
            }
        });
    }
}
