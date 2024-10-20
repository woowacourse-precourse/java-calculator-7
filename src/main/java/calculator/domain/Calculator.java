package calculator.domain;

import java.util.regex.Pattern;

public class Calculator {
    private String expression;

    public Calculator(String expression) {
        if(expression == null || expression.isEmpty()){
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        this.expression = expression;
    }

    private String[] getStrNumbers() {
        processDelimiters();
        return expression.split(",");
    }


    private void processDelimiters() {
        replaceBasicDelimiters();
        replaceCustomDelimiter();
    }

    // 모든 : 를 , 로 변경
    private void replaceBasicDelimiters() {
        expression = expression.replaceAll(":", ",");
    }

    // //와 \n 사이의 문자열을 ,로 변경
    private void replaceCustomDelimiter() {
        if (expression.startsWith("//")) {
            int startIdx = expression.indexOf("//");
            int endIdx = expression.indexOf("\\n");

            validateCustomDelimiter();

            String customDelimiter = expression.substring(startIdx + 2, endIdx);

            validateCustomDelimiterValue(customDelimiter);

            String beforeCustomDelimiter = expression.substring(0, startIdx);
            String afterCustomDelimiter = expression.substring(endIdx + 2);

            expression = (beforeCustomDelimiter + afterCustomDelimiter)
                    .replaceAll(Pattern.quote(customDelimiter), ",");
        }
    }

    // 커스텀 구분자가 잘못되었는지 확인
    private void validateCustomDelimiter() {
        if (expression.startsWith("//")) {
            int startIdx = expression.indexOf("//");
            int endIdx = expression.indexOf("\\n");

            if (startIdx == -1 || endIdx == -1) {
                throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
            }
        }
    }

    // 커스텀 구분자를 추출했을 때, 그 구분자에 숫자가 포함되어있거나, 비어있는 경우 예외처리
    private void validateCustomDelimiterValue(String customDelimiter) {
        if (customDelimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있습니다.");
        }
        if (customDelimiter.matches(".*\\d.*")) {
            throw new IllegalArgumentException("커스텀 구분자에 숫자가 포함되어 있습니다.");
        }
    }

    public int calculate() {
        String[] strNumbers = getStrNumbers();
        int sum = 0;
        // 음수가 들어올 경우 예외처리
        for (String strNumber : strNumbers) {
            int number = Integer.parseInt(strNumber);
            if (number < 0) {
                throw new IllegalArgumentException("음수가 입력되었습니다.");
            }
            sum += number;
        }
        return sum;
    }
}
