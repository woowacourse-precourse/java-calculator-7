package calculator.service;

import calculator.constant.ErrorMessage;
import calculator.number.domain.NumberService;

public class CalculatorProcess {
    public static Long sum(NumberService<? extends Number> number) {
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
