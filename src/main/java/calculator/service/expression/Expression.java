package calculator.service.expression;

import calculator.util.Constants;
import java.util.List;

public record Expression(String value) {

    public Expression {
        validateValue(value);
    }

    private void validateValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("식을 찾을 수 없어요. 입력하신 식을 확인해주세요.");
        }
    }

    public static Expression create(String value) {
        return new Expression(value);
    }

    public String[] split(List<String> separators) {
        String recognizedSeparatorsRegex = String.join(Constants.OR, separators);
        validateExpression(recognizedSeparatorsRegex, value);
        return value.split(recognizedSeparatorsRegex);
    }

    private void validateExpression(String possibleSeparatorsRegex, String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("계산할 식을 찾을 수 없어요. 입력값을 확인해주세요.");
        }
        if (hasUnrecognizedInput(possibleSeparatorsRegex, expression)) {
            throw new IllegalArgumentException("숫자와 사용 가능한 구분자 외에 다른 문자가 포함되어 있습니다. 입력값을 확인해주세요.");
        }
    }

    private boolean hasUnrecognizedInput(String possibleSeparatorsRegex, String expression) {
        return !expression.matches("[" + possibleSeparatorsRegex + Constants.POSITIVE_NUMBER_REGEX + "]+");
    }
}
