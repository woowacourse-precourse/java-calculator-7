package calculator.domain;

import java.util.List;

public class StringParser {

    private final static int INITIAL_NUMBER = 0;
    private final static int FIRST_NUMBER = 1;
    private final static int SECOND_NUMBER = 2;
    private final static int THIRD_NUMBER = 3;
    private final static String STANDARD_DELIMITER = "[,|:]";

    private final String inputStrings;

    public StringParser(final String inputStrings) {
        this.inputStrings = inputStrings;
    }

    private List<String> parseStandardStrings() {
        String[] standardStrings = inputStrings.split(STANDARD_DELIMITER);
        return List.of(standardStrings);
    }

    private List<String> parseCustomStrings() {
        String[] customStrings = inputStrings.split(extractCustomDelimiter());
        return List.of(customStrings);
    }

    private String extractCustomDelimiter() {
        return inputStrings.substring(SECOND_NUMBER, THIRD_NUMBER);
    }

    private String paresFirstString() {
        return inputStrings.substring(INITIAL_NUMBER, FIRST_NUMBER);
    }
}
