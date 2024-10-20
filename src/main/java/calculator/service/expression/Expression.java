package calculator.service.expression;

import calculator.service.separator.Separators;
import calculator.util.Constants;
import java.util.Arrays;

public record Expression(String value) {

    public Expression {
        validateValue(value);
    }

    private void validateValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("계산할 식을 찾을 수 없어요. 입력값을 확인해주세요.");
        }
    }

    public String[] split(Separators separators) {
        String recognizedSeparatorsRegex = separators.toRegexPattern();
        validateExpression(recognizedSeparatorsRegex, value);
        return value.split(recognizedSeparatorsRegex);
    }

    private void validateExpression(String possibleSeparatorsRegex, String expression) {
        if (hasUnrecognizedInput(possibleSeparatorsRegex, expression)) {
            throw new IllegalArgumentException("숫자와 사용 가능한 구분자 외에 다른 문자가 포함되어 있습니다. 입력값을 확인해주세요.");
        }
    }

    private boolean hasUnrecognizedInput(String possibleSeparatorsRegex, String expression) {
        return !expression.matches("[" + possibleSeparatorsRegex + Constants.POSITIVE_NUMBER_REGEX + "]+");
    }

    public long getSeparatorCount(Separators separators) {
        String possibleSeparatorsRegex = separators.toRegexPattern();
        String expressionWithoutSeparators = value.replaceAll(possibleSeparatorsRegex, "");
        return value.length() - expressionWithoutSeparators.length();
    }

    public long getOperandCount(Separators separators) {
        String[] operands = split(separators);
        return Arrays.stream(operands)
                .filter(operand -> !operand.isEmpty())
                .count();
    }
}
