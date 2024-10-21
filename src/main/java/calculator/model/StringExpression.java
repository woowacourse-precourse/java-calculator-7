package calculator.model;

import static calculator.constant.ErrorMessage.INVALID_INPUT;
import static calculator.constant.ErrorMessage.WRONG_DELIMITER;

import calculator.constant.Delimiter;
import calculator.util.DelimiterParser;

public class StringExpression {
    private final String expression;
    private final String customDelimiters;

    public StringExpression(String expression) {
        validateNullOrEmpty(expression);
        this.expression = expression.replace("\\n", "\n");
        this.customDelimiters = DelimiterParser.parseCustomDelimiters(this.expression);
    }

    public String[] split() {
        if (expression.trim().isEmpty()) {
            return new String[]{"0"}; // 빈 문자열인 경우 "0" 반환
        }

        // 기본 구분자 및 커스텀 구분자 결합
        String delimiters = Delimiter.DEFAULT_DELIMITERS;
        if (!customDelimiters.isEmpty()) {
            delimiters += "|" + customDelimiters;
        }

        // 커스텀 구분자 선언을 제거하고 나머지 문자열을 분리
        String processedExpression = expression.replaceAll("//(.+?)\n", "");

        // 기본 구분자에 대한 예외 처리 (커스텀 구분자는 예외처리하지 않음)
        // 기본 구분자만 연속으로 오는 경우
        if (processedExpression.matches(".*[,|:]{2,}.*")) {
            throw new IllegalArgumentException(WRONG_DELIMITER);
        }

        // 커스텀 구분자 또는 기본 구분자가 마지막에 있는 경우
        if (processedExpression.matches(".*[" + delimiters + "]$")) {
            throw new IllegalArgumentException(WRONG_DELIMITER);
        }

        return processedExpression.split(delimiters);
    }

    private void validateNullOrEmpty(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
