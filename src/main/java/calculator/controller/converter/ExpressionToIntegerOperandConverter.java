package calculator.controller.converter;

import calculator.model.expression.Expression;
import calculator.model.operand.IntegerOperand;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionToIntegerOperandConverter implements Converter<Expression, IntegerOperand> {

    @Override
    public IntegerOperand convert(final Expression expression) {
        final List<Integer> numbers = expression.getOperands().stream()
                .map(this::parseInteger)
                .collect(Collectors.toList());
        return new IntegerOperand(numbers);
    }

    private int parseInteger(final String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 입력 값이 포함되어 있습니다: " + numberStr, e);
        }
    }
}
