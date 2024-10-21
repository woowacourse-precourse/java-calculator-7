package calculator.strategy;

public interface DelimiterStrategy {
    String[] getDelimiters();
    String extractNumberPart(String input);
}
