package calculator.presentation;

public final class CalculatorRequest {

    private final String tokens;
    private final String customDelimiter;

    public CalculatorRequest(String tokens, String customDelimiter) {
        this.tokens = tokens;
        this.customDelimiter = customDelimiter;
    }

    public String getTokens() {
        return tokens;
    }

    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
