package calculator.parser;

import java.util.List;

public interface NumberParser {
    List<Integer> parseNumbers(List<String> numberStrings);
}