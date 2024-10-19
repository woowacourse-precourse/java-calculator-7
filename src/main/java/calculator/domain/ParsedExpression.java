package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParsedExpression {
    private final String realExpression;

    public ParsedExpression(String realExpression, Delimiter delimiter) {
        validateDelimiter(delimiter);
        validateSyntax();
        this.realExpression = realExpression;
    }

    public List<Integer> extractNumbers() {
        return Arrays.stream(realExpression.split("\\D+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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
