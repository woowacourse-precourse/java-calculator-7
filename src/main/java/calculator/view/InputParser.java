package calculator.view;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;

import java.util.Arrays;

public class InputParser {

    private static final int START_INDEX = 0;
    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\\n";

    public Numbers parseNumbers(Delimiters delimiters, String input) {
        String delimiterRegex = String.join("|", delimiters.getElements());
        String numberInput = removeCustomDelimiter(input);
        return new Numbers(Arrays.stream(numberInput.split(delimiterRegex))
                .toList());
    }

    private String removeCustomDelimiter(String input) {
        if (hasCustomDelimiter(input)) {
            input = input.substring(input.indexOf(CUSTOM_END) + 2);
        }
        return input;
    }

    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_START) && input.contains(CUSTOM_END);
    }

    public String parseCustomDelimiter(String input) {
        return input.substring(START_INDEX, input.indexOf(CUSTOM_END))
                .replace(CUSTOM_START, "");
    }
}
