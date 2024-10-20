package calculator;

public class Calculator {
    private final StringParser parser;

    public Calculator(StringParser parser) {
        this.parser = parser;
    }

    public int calculateSum() {
        String[] tokens = parser.getTokens();
        return calculateSumFromTokens(tokens);
    }

    private int calculateSumFromTokens(String[] tokens) {
        int sum = 0;

        for (String token : tokens) {
            int number = parseAndValidateNumber(token);
            sum += number;
        }
        return sum;
    }

    private int parseAndValidateNumber(String token) {
        int number = parseNumber(token);
        NumberValidator.validatePositive(number);

        return number;
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 입력: " + token);
        }
    }
}