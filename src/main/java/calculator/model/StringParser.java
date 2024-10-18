package calculator.model;


import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_BACK;
import static calculator.common.DelimiterConstant.DELIMITER_SEPERATOR;

import calculator.common.NumberValidator;
import java.util.Arrays;
import java.util.List;

public class StringParser {

    private final DelimiterStore delimiterStore;

    public StringParser(DelimiterStore delimiterStore) {
        this.delimiterStore = delimiterStore;
    }

    public String splitTarget(String value) {
        return value.substring(value.lastIndexOf(DELIMITER_CREATOR_BACK) + DELIMITER_CREATOR_BACK.length());
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
