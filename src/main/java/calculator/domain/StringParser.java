package calculator.domain;

import java.util.List;

public class StringParser {

    private final static int INITIAL_NUMBER = 0;
    private final static int FIRST_NUMBER = 1;
    private final static int SECOND_NUMBER = 2;
    private final static int THIRD_NUMBER = 3;
    private final static String STANDARD_DELIMITER = "[,|:]";
    private static final String FIRST_CUSTOM_STRING = "/";

    private final List<String> numbers;

    public StringParser(String inputStrings) {
        this.numbers = parseStrings(inputStrings);
    }

    public List<String> getNumbers() {
        return numbers;
    }

    private List<String> parseStrings(String inputStrings) {
        if (!paresFirstString(inputStrings).equals(FIRST_CUSTOM_STRING)) {
            return parseStandardStrings(inputStrings);
        }
        return parseCustomStrings(inputStrings);
    }

    private List<String> parseStandardStrings(String inputStrings) {
        String[] standardStrings = inputStrings.split(STANDARD_DELIMITER);
        return List.of(standardStrings);
    }

    private List<String> parseCustomStrings(String inputStrings) {
        String[] customStrings = inputStrings.split(extractCustomDelimiter(inputStrings));
        return List.of(customStrings);
    }

    private String extractCustomDelimiter(String inputStrings) {
        return inputStrings.substring(SECOND_NUMBER, THIRD_NUMBER);
    }

    private String paresFirstString(String inputStrings) {
        return inputStrings.substring(INITIAL_NUMBER, FIRST_NUMBER);
    }
}
