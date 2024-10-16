package calculator;

public class Calculator {

    private static final String DEFAULT_SEPARATORS = ",:";

    private String exp;
    private String regex;

    public Calculator(String expression) {
        this.regex = "[" + DEFAULT_SEPARATORS + "]";
        this.exp = expression;
    }
}