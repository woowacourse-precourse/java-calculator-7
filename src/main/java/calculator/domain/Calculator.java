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
        processDelimiters();
        return expression.split(":");
    }

    private void processDelimiters() {
        replaceBasicDelimiters();
        replaceCustomDelimiter();
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

}
