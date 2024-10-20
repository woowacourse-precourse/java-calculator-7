package calculator.domain;

import java.util.regex.Pattern;

public class DelimiterProcessor {
    private String expression;

    public DelimiterProcessor(String expression) {
        this.expression = expression;
    }

    public String[] process() {
        replaceBasicDelimiters();
        replaceCustomDelimiter();

        validateDelimiterPresence();
        return expression.split(":");
    }

    private void validateDelimiterPresence() {
        if (!expression.contains(":")) {
            throw new IllegalArgumentException("구분자가 없습니다.");
        }
    }

    private void replaceBasicDelimiters() {
        expression = expression.replaceAll(",", ":");
    }

    private void replaceCustomDelimiter() {
        if (expression.startsWith("//")) {
            int startIdx = expression.indexOf("//");
            int endIdx = expression.indexOf("\\n");
            validateCustomDelimiterPresence(startIdx, endIdx);

            String customDelimiter = expression.substring(startIdx + 2, endIdx);
            validateCustomDelimiterValidity(customDelimiter);

            String beforeCustomDelimiter = expression.substring(0, startIdx);
            String afterCustomDelimiter = expression.substring(endIdx + 2);

            expression = (beforeCustomDelimiter + afterCustomDelimiter)
                    .replaceAll(Pattern.quote(customDelimiter), ":");
        }
    }

    private void validateCustomDelimiterPresence(int startIdx, int endIdx) {
        if (startIdx == -1 || endIdx == -1) {
            throw new IllegalArgumentException("커스텀 구분자를 지정하지 못했습니다.");
        }
    }

    private void validateCustomDelimiterValidity(String customDelimiter) {
        if (isInvalidCustomDelimiter(customDelimiter)) {
            throw new IllegalArgumentException("커스텀 구분자가 유효하지 않습니다.");
        }
    }

    private boolean isInvalidCustomDelimiter(String customDelimiter) {
        return customDelimiter.isEmpty() ||
                customDelimiter.equals(",") ||
                customDelimiter.equals(":");
    }
}
