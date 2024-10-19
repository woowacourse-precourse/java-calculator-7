package calculator.domain;

public class ParsedExpression {
    private final String realExpression;

    public ParsedExpression(String realExpression, Delimiter delimiter) {
        validateDelimiter(delimiter);
        validateSyntax();
        this.realExpression = realExpression;
    }


    private void validateDelimiter(Delimiter delimiter) {
        for (char c : realExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                continue;
            }
            if (!delimiter.contains(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateSyntax() {
        boolean beforeDelimiter = true;
        for (char c : realExpression.toCharArray()) {
            if (!Character.isDigit(c) && beforeDelimiter) {
                throw new IllegalArgumentException();
            }
            beforeDelimiter = !Character.isDigit(c);
        }
    }
}
