package calculator.controller.converter;

import calculator.model.expression.Expression;
import calculator.model.operand.PositiveIntegerOperand;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionToPositiveIntegerOperandConverter implements Converter<Expression, PositiveIntegerOperand> {

    @Override
    public PositiveIntegerOperand convert(final Expression expression) {
        try {
            final List<Integer> numbers = expression.getOperands().stream()
                    .map(number -> {
                        int parsedNumber = Integer.parseInt(number);
                        if (parsedNumber < 0) {
                            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
                        }
                        return parsedNumber;
                    })
                    .collect(Collectors.toList());

            return new PositiveIntegerOperand(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 입력 값이 포함되어 있습니다: " + e.getMessage(), e);
        }
    }
}
