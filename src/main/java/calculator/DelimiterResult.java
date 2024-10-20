package calculator;

public record DelimiterResult(
        boolean hasCustomDelimiter,
        String customDelimiter,
        String expressionAfterDelimiter) {
}
