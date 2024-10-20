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
        List<String> numbers = splitter.split(",|:");  // 기본 구분자 처리

        return sum(numbers);
    }

    private int sum(List<String> numbers) {
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                }
                sum += num;
            }
        }
        return sum;
    }
}