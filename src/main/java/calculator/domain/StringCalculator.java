package calculator.domain;

import calculator.view.InputParser;

public class StringCalculator {

    private static final String CUSTOM_START = "//";
    private final Numbers numbers;

    public StringCalculator(String input) {
        InputParser inputParser = new InputParser();
        Delimiters delimiters = new Delimiters();
        if (hasCustomDelimiter(input)) {
            delimiters.addDelimiter(inputParser.parseCustomDelimiter(input));
        }
        this.numbers = inputParser.parseNumbers(delimiters, input);
    }


    private boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_START);
    }

    public int sum() {
        return numbers.sum();
    }
}
