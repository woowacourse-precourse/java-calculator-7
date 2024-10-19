package calculator.view.input.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultDelimiterParser {
    private static final String WHITESPACE = " ";

    public List<Integer> parseInputNumbers(String input) {
        input = removeDelimiter(input);

        return Arrays.stream(input.split(WHITESPACE))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String removeDelimiter(String input) {
        for (String delimiter : getDelimiterSymbols()) {
            input = input.replace(delimiter, WHITESPACE);
        }

        return input;
    }

    public static List<String> getDelimiterSymbols() {
        return Arrays.stream(Delimiter.values())
                .map(Delimiter::getSymbol)
                .collect(Collectors.toList());
    }
}
