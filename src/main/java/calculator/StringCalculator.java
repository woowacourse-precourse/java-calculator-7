package calculator;

import parser.DelimiterParser;
import parser.NumberParser;
import validator.InputValidator;

import java.util.Arrays;

public class StringCalculator {

    private final DelimiterParser delimiterParser = new DelimiterParser();
    private final NumberParser numberParser = new NumberParser();
    private final InputValidator inputValidator = new InputValidator();

    public int add(String input) {
        inputValidator.validate(input);  // 입력 값 유효성 검사

        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = delimiterParser.parseDelimiters(input);
        String[] numbers = numberParser.parseNumbers(input, delimiter);

        // 스트림을 사용하여 숫자 합산
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
