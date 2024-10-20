package calculator.view.input.parser;

import calculator.view.input.validator.NumberValidator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultDelimiterParser implements DelimiterParser {
    private static final String WHITESPACE = " ";
    private final NumberValidator numberValidator = new NumberValidator();
    private final InputParser inputParser = new InputParser();

    public List<Integer> parseInputNumbers(String input) {
        String parsedInput = inputParser.parseEmptyInput(input);
        String inputWithoutDelimiters = removeDelimiter(parsedInput);

        numberValidator.validate(inputWithoutDelimiters);

        return Arrays.stream(inputWithoutDelimiters.split(WHITESPACE))
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
