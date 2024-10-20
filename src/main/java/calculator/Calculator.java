package calculator;

public class Calculator {
    private final StringParser parser;

    public Calculator(StringParser parser) {
        this.parser = parser;
    }

    public int calculateSum() {
        String[] tokens = parser.getTokens();

        int sum = 0;

        for (String token : tokens) {
            int number = parseNumber(token);
            NumberValidator.validate(number);
            sum += number;
        }

        return sum;
    }

    private int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 입력: " + token);
        }
    }
}
