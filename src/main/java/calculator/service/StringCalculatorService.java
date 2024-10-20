package calculator.service;

import calculator.util.StringSplitter;
import calculator.validator.InputValidator;
import java.util.List;

public class StringCalculatorService {
    private final InputValidator inputValidator;

    public StringCalculatorService(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        inputValidator.validate(input);
        StringSplitter splitter = new StringSplitter(input);
        List<String> numbers;
        if (input.startsWith("//")) {
            numbers = splitter.split("");  // 커스텀 구분자는 StringSplitter 내에서 처리됨
        } else {
            numbers = splitter.split(",|:");
        }

        return sum(numbers);
    }

    private int sum(List<String> numbers) {
        return numbers.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .peek(this::validateNonNegative)
                .sum();
    }

    private void validateNonNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
    }
}