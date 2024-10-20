package calculator.parser;

import java.util.List;

public interface NumberParser {
    PositiveNumbers parseNumbers(List<String> numberStrings);
}