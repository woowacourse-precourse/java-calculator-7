package calculator.service.calculator;

import calculator.constant.ErrorMessage;
import calculator.number.domain.Number;

public class CalculatorProcess {
    public Long sum(Number number) {
        try {
            return number.getNumbers()
                    .stream()
                    .mapToLong(Long::longValue)
                    .reduce(0L, Math::addExact);
        } catch (ArithmeticException arithmeticException) {
            throw new IllegalArgumentException(ErrorMessage.MAX_VALUE_ERROR);
        }
    }
}
