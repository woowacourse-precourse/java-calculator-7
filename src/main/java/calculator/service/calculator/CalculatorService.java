package calculator.service.calculator;

import calculator.domain.Operator;
import calculator.domain.number.Number;
import calculator.domain.number.Numbers;

public class CalculatorService {

    public Number operate(Operator operator, Numbers numbers) {
        return operator.apply(numbers);
    }
}
