package calculator.service;

import calculator.constant.CalculatorConstants;
import calculator.constant.ExceptionMessageConstants;
import calculator.validator.InputValidator;
import java.util.List;

public class StringCalculatorService {
    private final InputValidator inputValidator;
    private final StringSplitter stringSplitter;

    public StringCalculatorService(InputValidator inputValidator, StringSplitter stringSplitter) {
        this.inputValidator = inputValidator;
        this.stringSplitter = stringSplitter;
    }

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        if (input.length() > CalculatorConstants.MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessageConstants.INPUT_TOO_LONG,
                            CalculatorConstants.MAX_INPUT_LENGTH));
        }

        inputValidator.validate(input);
        List<String> numbers = stringSplitter.split(input);
        return sum(numbers);
    }

    private int sum(List<String> numbers) {
        return numbers.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToLong(Long::parseLong)
                .peek(this::validateNumberRange)
                .mapToInt(Math::toIntExact)
                .sum();
    }

    private void validateNumberRange(long num) {
        if (num < 0) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessageConstants.NEGATIVE_NOT_ALLOWED, num));
        }
        if (num > CalculatorConstants.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(ExceptionMessageConstants.NUMBER_TOO_LARGE, CalculatorConstants.MAX_NUMBER));
        }
    }
}