package calculator;

public class Calculator {

    private static final String DEFAULT_SEPARATORS = ",:";

    private String exp;
    private String regex;

    public Calculator(String expression) {
        this.regex = "[" + DEFAULT_SEPARATORS + "]";
        this.exp = expression;
    }

    public Calculator(String expression, char customSeparator) {
        this(expression);
        this.regex = "[" + DEFAULT_SEPARATORS + customSeparator + "]";
    }

    public int calculate() {
        String[] parts = exp.split(regex);
        int result = 0;

        for (String part : parts) {
            if (part.isBlank()) {
                continue;
            }

            try {
                int n = Integer.parseInt(part);
                if (n < 0) {
                    throw new IllegalArgumentException();
                }

                result += n;
            } catch (NumberFormatException expected) {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }
}