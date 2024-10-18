package calculator.domain.calculator.service;

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
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값입니다: " + str);
        }
    }
}
