package calculator.controller.converter;

import calculator.model.expression.Expression;
import calculator.model.operand.PositiveIntegerOperand;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionToPositiveIntegerOperandConverter implements Converter<Expression, PositiveIntegerOperand> {

    @Override
    public PositiveIntegerOperand convert(final Expression expression) {
        final List<Integer> numbers = expression.getOperands().stream()
                .map(this::parseAndValidatePositiveInteger)
                .collect(Collectors.toList());
        return new PositiveIntegerOperand(numbers);
    }

    private int parseAndValidatePositiveInteger(final String numberStr) {
        final int parsedNumber = parseInteger(numberStr);
        validatePositive(parsedNumber);
        return parsedNumber;
    }

    private int parseInteger(final String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 입력 값이 포함되어 있습니다: " + numberStr, e);
        }
    }

    private static void validatePositive(int parsedNumber) {
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
        }
    }
}
