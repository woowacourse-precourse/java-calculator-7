package calculator.service.calculator.impl;

import calculator.validator.constant.ErrorMessage;
import calculator.number.domain.NumberService;
import calculator.service.calculator.CalculatorService;

public class LongCalculatorProcess implements CalculatorService {
    @Override
    public Number sum(NumberService number) {
        try {
            return number.getNumbers()
                    .stream()
                    .mapToLong(Number::longValue)
                    .reduce(0L, Math::addExact);
        } catch (ArithmeticException arithmeticException) {
            throw new IllegalArgumentException(ErrorMessage.MAX_VALUE_ERROR);
        }
    }
}
