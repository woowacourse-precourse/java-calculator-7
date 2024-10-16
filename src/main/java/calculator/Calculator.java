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
}