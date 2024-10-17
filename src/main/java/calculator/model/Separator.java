package calculator.model;

public class Separator {
    private final String separator;

    public Separator(String expression) {
        this.separator = extractSeparator(expression);
    }

    public String extractSeparator(String expression) {
        String defaultSeparator = ",:";
        if (expression.startsWith("//")) {
            int start = expression.indexOf("//") + 2;
            int end = expression.indexOf("\\n");
            String customSeparator = expression.substring(start, end);
            return defaultSeparator + customSeparator;
        }
        return defaultSeparator;
    }

    public String getSeparator() {
        return separator;
    }
}
