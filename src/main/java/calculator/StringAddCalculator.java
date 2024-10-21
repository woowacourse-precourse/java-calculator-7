package calculator;

public class StringAddCalculator {
    private final Parser parser;
    private final Validator validator;

    public StringAddCalculator(Parser parser, Validator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public int add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        String[] numbers = parser.parse(input);
        validator.validate(numbers);
        return sum(numbers);
    }

    private int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                result += Integer.parseInt(number);
            }
        }
        return result;
    }
}
