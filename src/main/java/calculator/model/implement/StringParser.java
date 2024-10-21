package calculator.model.implement;


import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_BACK;
import static calculator.common.DelimiterConstant.DELIMITER_SEPERATOR;

import calculator.model.domain.CustomNumber;
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

    public List<CustomNumber> parseToNumbers(String value) {
        String[] splitValues = value.split(getAllSpliterator());
        return Arrays.stream(splitValues)
                .map(CustomNumber::fromString)
                .toList();
    }

    private String getAllSpliterator() {
        List<String> delimiters = delimiterStore.getAllDelimiters();
        return String.join(DELIMITER_SEPERATOR, delimiters);
    }
}
