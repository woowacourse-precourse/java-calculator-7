package calculator.utils.extractor;

public class ExpressionExtractor {

    public static String extractExpression(String input,
                                           boolean hasCustomDelimiter) {
        return hasCustomDelimiter ? input.substring(5) : input;
    }
}
