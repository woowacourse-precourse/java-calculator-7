package calculator.view.input.parser;

public class InputParser {
    private static final String DEFAULT_STRING = "0";

    public String parseEmptyInput(String input) {
        if (input.isEmpty()) {
            return DEFAULT_STRING;
        }

        return input;
    }
}
