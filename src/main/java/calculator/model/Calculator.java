package calculator.model;

import static calculator.validate.NumberValidator.validateNumber;

import calculator.parser.DelimiterExtractor;
import java.util.Objects;

public class Calculator {

    private static int result;

    private final DelimiterExtractor extractor = new DelimiterExtractor();

    public void calculate(String input) {
        if (Objects.equals(input, "")) {
            result = 0;
            return;
        }
        String[] numbers;
        if (input.startsWith("//")) {
            String customDelimiter = extractor.extractCustomDelimiter(input);
            numbers = input.substring(5).split(customDelimiter);
            calculateSum(numbers);
            return;
        }
        numbers = input.split(extractor.getDefaultDelimiter());
        calculateSum(numbers);
    }

    private void calculateSum(String[] numbers) {
        for (String number : numbers) {
            try {
                validateNumber(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
            result += Integer.parseInt(number);
        }
    }

    public int getResult() {
        return result;
    }
}
