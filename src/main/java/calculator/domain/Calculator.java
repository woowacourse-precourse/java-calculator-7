package calculator.domain;

import java.util.regex.Pattern;

public class Calculator {

    private String expression;

    public Calculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }

        this.expression = expression;
    }

    public int sum() {
        int result = 0;

        for (int number : getIntNumbers()) {
            result += number;
        }

        return result;
    }

    private int[] getIntNumbers() {
        return new Numbers().parseToIntArray(getStrNumbers());
    }

    private String[] getStrNumbers() {
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
