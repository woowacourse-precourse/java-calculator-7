package calculator.processor.handler.calculating;

import calculator.processor.domain.Number;
import calculator.processor.domain.Numbers;

public interface CalculatingHandler {

    Number handle(Numbers numbers);
}
