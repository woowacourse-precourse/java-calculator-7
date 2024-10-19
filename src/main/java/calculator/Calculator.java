package calculator;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = ":,";

    private final String delimitersRegex;

    public Calculator(String customDelimiter) {
        this.delimitersRegex = "[" + DEFAULT_DELIMITERS + customDelimiter + "]";
    }

    public double getResult(String expression) {
        double result = 0;

        for (String token : expression.split(this.delimitersRegex)) {
            if (token.isEmpty()) {
                continue;
            }

            double toAdd = parseDouble(token);
            if (isNotPositive(toAdd)) {
                throw new IllegalArgumentException();
            }

            result += toAdd;
        }
        return result;
    }

    private static double parseDouble(String token) {
        // Double.parseDouble에서 공백문자는 예외처리하지 않아 따로 처리
        if (containsSpace(token)) {
            throw new IllegalArgumentException();
        }

        try {
            return Double.parseDouble(token);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean containsSpace(String token) {
        for (int i = 0; i < token.length(); ++i) {
            if (isSpace(token.charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSpace(char ch) {
        return ch <= ' '; // Double.parseDouble에서 trim이 자르는 문자
    }

    private static boolean isNotPositive(double value) {
        return value <= 0;
    }
}
