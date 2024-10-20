package calculator.calculatorApplication.domain.calculation;

import calculator.calculatorApplication.domain.parser.vo.PositiveNumbers;
import java.util.List;

public interface NumberParser {
    PositiveNumbers parseNumbers(List<String> numberStrings);
}