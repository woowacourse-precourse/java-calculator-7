package calculator.model.implement;


import static calculator.common.DelimiterConstant.DELIMITER_CREATOR_BACK;
import static calculator.common.DelimiterConstant.DELIMITER_GROUP_BACK_PREFIX;
import static calculator.common.DelimiterConstant.DELIMITER_GROUP_FRONT_PREFIX;
import static calculator.common.DelimiterConstant.DELIMITER_SEPERATOR;

import calculator.common.DelimiterConstant;
import calculator.model.domain.CustomNumber;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
        Set<String> delimiters = delimiterStore.getAllDelimiters();
        String spliterators = String.join(DELIMITER_SEPERATOR, delimiters);
        return DELIMITER_GROUP_FRONT_PREFIX + spliterators + DELIMITER_GROUP_BACK_PREFIX;
    }
}