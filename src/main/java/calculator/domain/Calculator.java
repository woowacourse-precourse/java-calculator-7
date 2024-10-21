package calculator.domain;

public class Calculator {
    private String delimeter;
    private String[] tokens;

    public Calculator(String delimeter, String[] tokens) {
        this.delimeter = delimeter;
        this.tokens = tokens;
    }

    public String[] getTokens() {
        return tokens;
    }
}
