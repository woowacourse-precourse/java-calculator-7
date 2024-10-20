package calculator.domain.calculation;

import calculator.domain.parser.vo.PositiveNumbers;
import java.util.List;

public interface NumberParser {
    PositiveNumbers parseNumbers(List<String> numberStrings);
}