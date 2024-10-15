package calculator;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ":,";

    private final String regex;

    public Calculator(String customDelimiter) {
        regex = "[" + DEFAULT_DELIMITERS + customDelimiter + "]";
    }

    public double getResult(String expression) {
        double result = 0;

        for (String token : expression.split(regex)) {
            double toAdd = parseDouble(token);
            if (isNotPositive(toAdd)) {
                throw new IllegalArgumentException();
            }

            result += toAdd;
        }
        return result;
    }

    private boolean isNotPositive(double value) {
        return value <= 0;
    }

    private double parseDouble(String token) {
        try {
            return Double.parseDouble(token);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
