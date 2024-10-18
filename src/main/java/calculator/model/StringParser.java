package calculator.model;


import calculator.common.NumberValidator;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    private final static String DELIMITER_SEPERATOR = "|";
    private final static String CUSTOM_CREATOR_BACK = "\\n";

    private final DelimiterStore delimiterStore;

    public StringParser(DelimiterStore delimiterStore) {
        this.delimiterStore = delimiterStore;
    }

    public String splitTarget(String value) {
        return value.substring(value.lastIndexOf(CUSTOM_CREATOR_BACK) + CUSTOM_CREATOR_BACK.length());
    }

    public List<Integer> parseToNumbers(String value) {
        String[] splitValues = value.split(getAllSpliterator());
        return Arrays.stream(splitValues)
                .map(this::parseIntAndValidate)
                .toList();
    }

    private Integer parseIntAndValidate(String splitValue) {
        int parsedValue = Integer.parseInt(splitValue);
        NumberValidator.validatePositive(parsedValue);
        return parsedValue;
    }

    private String getAllSpliterator() {
        List<String> delimiters = delimiterStore.getAllDelimiters();
        return String.join(DELIMITER_SEPERATOR, delimiters);
    }
}
