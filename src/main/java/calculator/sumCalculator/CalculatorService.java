package calculator.sumCalculator;

import calculator.sumCalculator.domain.Calculator;

public class CalculatorService {

    //추출한 숫자로 덧셈 연산한다.
    public Integer sumNumbers(Calculator calculator) {
        return calculator.sum();
    }
}
