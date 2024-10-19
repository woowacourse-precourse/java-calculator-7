package calculator.processor.handler.calculating;

import calculator.processor.domain.Number;
import calculator.processor.domain.Numbers;

public class SumHandler implements CalculatingHandler{

    public Number handle(Numbers numbers) {
        return numbers.sum();
    }
}
