package calculator;

public class Calculator {

    private static final String DEFAULT_SEPARATORS = ",:";

    private String exp;
    private String regex;

    public Calculator(String expression) {
        this.regex = "[" + DEFAULT_SEPARATORS + "]";
        this.exp = expression;

        if (hasCustomSeparator()) {
            this.regex = "[" + DEFAULT_SEPARATORS + exp.charAt(2) + "]";
            this.exp = exp.substring(5);
        }
    }

    private boolean hasCustomSeparator() {
        return exp.length() >= 5
                && exp.startsWith("//")
                && exp.indexOf("\\n") == 3
                && !isNumeric(exp.charAt(2));
    }

    private boolean isNumeric(char c) {
        try {
            Double.parseDouble(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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