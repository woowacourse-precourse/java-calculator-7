package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParsedExpression {
    private final String realExpression;

    public ParsedExpression(String realExpression, Delimiter delimiter) {
        this.realExpression = realExpression;
        validateDelimiter(delimiter);
        validateSyntax();
    }

    public List<Integer> extractNumbers() {
        if (realExpression.isEmpty()) {
            return new ArrayList<>();
        }
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
                throw new IllegalArgumentException("Delimiter에 포함된 구분자만 수식에 포함시킬 수 있습니다: " + c);
            }
        }
    }

    public void validateSyntax() {
        boolean beforeDelimiter = true;
        for (char c : realExpression.toCharArray()) {
            if (!Character.isDigit(c) && beforeDelimiter) {
                throw new IllegalArgumentException("구분자가 연속해서 두 번 등장");
            }
            beforeDelimiter = !Character.isDigit(c);
        }
    }
}
