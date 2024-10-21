package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class StringParser {

    private static final int SECOND_NUMBER = 2;
    private static final String STANDARD_DELIMITER = "[,|:]";
    private static final String FIRST_CUSTOM_STRING = "//";
    private static final String CUSTOM_NUMBER_PART_DELIMITER = "\\";

    private final String inputStrings;

    public StringParser(String inputStrings) {
        this.inputStrings = inputStrings;
    }

    public String extractDelimiter() {
        if (!inputStrings.startsWith(FIRST_CUSTOM_STRING)) {
            return STANDARD_DELIMITER;
        }
        return Pattern.quote(inputStrings.substring(SECOND_NUMBER, inputStrings.indexOf(CUSTOM_NUMBER_PART_DELIMITER)));
    }

    public List<String> parseStrings(String delimiter) {
        if (Objects.equals(delimiter, STANDARD_DELIMITER)) {
            return parseStandardStrings(delimiter);
        }
        return parseCustomStrings(delimiter);
    }

    private List<String> parseStandardStrings(String delimiter) {
        String[] standardStrings = inputStrings.split(delimiter);
        return List.of(standardStrings);
    }

    private List<String> parseCustomStrings(String delimiter) {
        String numberParts = inputStrings.substring(inputStrings.indexOf(CUSTOM_NUMBER_PART_DELIMITER) + SECOND_NUMBER);
        String[] customStrings = numberParts.split(delimiter);
        return List.of(customStrings);
    }
}
