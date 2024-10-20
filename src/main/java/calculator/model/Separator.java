package calculator.model;

public class Separator {
    public String raw = ",:";

    private void append(String customSeparator) {
        raw += customSeparator;
    }

    public String consumeCustomSeparator(String expression) {
        if(hasCustomSeparator(expression)) {
            int newlineIndex = expression.indexOf("\n");
            String customSeparator = expression.substring(2, newlineIndex);
            append(customSeparator);

            return expression.substring(newlineIndex + 1);
        }

        return expression;
    }

    private boolean hasCustomSeparator(String expression) {
        boolean startsWithDoubleSlash = expression.startsWith("//");
        boolean containsNewline = expression.contains("\n");

        return startsWithDoubleSlash && containsNewline;
    }
}
