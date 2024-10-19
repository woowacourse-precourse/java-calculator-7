package calculator.controller.converter;

import calculator.model.expression.Expression;
import calculator.model.operand.IntegerOperand;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionToIntegerOperandConverter implements Converter<Expression, IntegerOperand> {

    @Override
    public IntegerOperand convert(final Expression expression) {
        try {
            final List<Integer> numbers = expression.getOperands().stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new IntegerOperand(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 입력 값이 포함되어 있습니다: " + e.getMessage(), e);
        }
    }
}
