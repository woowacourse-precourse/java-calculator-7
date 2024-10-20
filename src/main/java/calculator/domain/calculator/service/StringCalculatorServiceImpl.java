package calculator.domain.calculator.service;

import static calculator.global.exception.ErrorMessage.NEGATIVE_NUMBER_NOT_ALLOWED;
import static calculator.global.exception.ErrorMessage.NON_NUMERIC_INPUT;

import calculator.domain.calculator.domain.StringCalculator;
import java.util.Arrays;

public class StringCalculatorServiceImpl implements StringCalculatorService {

    private static StringCalculatorServiceImpl instance;

    private StringCalculatorServiceImpl() {}

    public static StringCalculatorService getInstance() {
        if (instance == null) {
            instance = new StringCalculatorServiceImpl();
        }
        return instance;
    }

    @Override
    public int calculate(String input) {
        final StringCalculator stringCalculator = StringCalculator.of(input);
        int[] numbers = parseNumbers(stringCalculator);
        return sum(numbers);
    }

    private int[] parseNumbers(StringCalculator calculator) {
        String[] str = calculator.getInput().split(calculator.getDelimiter().getPattern());
        return Arrays.stream(str)
                .mapToInt(this::parseAndValidateNumber)
                .toArray();
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private int parseAndValidateNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            if (number < 0) {
                throw new IllegalArgumentException(NEGATIVE_NUMBER_NOT_ALLOWED.getMessage());
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT.getMessage());
        }
    }
}
