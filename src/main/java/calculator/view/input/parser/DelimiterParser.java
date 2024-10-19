package calculator.view.input.parser;

import java.util.List;

public interface DelimiterParser {
    List<Integer> parseInputNumbers(String input);

    String removeDelimiter(String input);
}
