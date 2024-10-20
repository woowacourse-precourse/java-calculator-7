package calculator.service;

import calculator.validator.InputValidator;
import java.util.List;

public class StringCalculatorService {
    private static final int MAX_INPUT_LENGTH = 1000;
    private static final long MAX_NUMBER = Integer.MAX_VALUE;
    private final InputValidator inputValidator;
    private final StringSplitterService stringSplitter;

    public StringCalculatorService(InputValidator inputValidator, StringSplitterService stringSplitter) {
        this.inputValidator = inputValidator;
        this.stringSplitter = stringSplitter;
    }

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        if (input.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException("입력 문자열이 너무 깁니다. 최대 " + MAX_INPUT_LENGTH + "자까지 입력 가능합니다.");
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
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
        if (num > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자가 너무 큽니다. 최대 " + MAX_NUMBER + "까지 허용됩니다.");
        }
    }
}