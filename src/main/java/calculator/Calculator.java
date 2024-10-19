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
            if (toAdd <= 0) {
                throw new IllegalArgumentException();
            }

            result += toAdd;
        }
        return result;
    }

    private static double parseDouble(String token) {
        // Double.parseDouble에서 공백문자는 예외처리하지 않아 따로 처리
        checkSpace(token);

        try {
            return Double.parseDouble(token);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkSpace(String token) {
        for (int i = 0; i < token.length(); ++i) {
            if (token.charAt(i) <= ' ') { // Double.parseDouble에서 trim이 자르는 문자
                throw new IllegalArgumentException();
            }
        }
    }
}
