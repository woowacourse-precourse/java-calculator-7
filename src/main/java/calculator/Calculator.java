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

            // parseDouble은 공백문자 무시
            if (containsSpace(token)) {
                throw new IllegalArgumentException();
            }

            double toAdd = parseDouble(token);
            if (isNotPositive(toAdd)) {
                throw new IllegalArgumentException();
            }

            result += toAdd;
        }
        return result;
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
        return ch <= ' '; // trim이 자르는 문자
    }

    private static boolean isNotPositive(double value) {
        return value <= 0;
    }

    private static double parseDouble(String token) {
        try {
            return Double.parseDouble(token);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
