package calculator.domain;

import static calculator.util.Const.COLON;
import static calculator.util.Const.COMMA;
import static calculator.util.Const.DEFAULT_DELIMITER_SIZE;
import static calculator.util.Const.DELIMITER_JOINER;
import static calculator.util.Const.NUMERIC_ERROR_MESSAGE;
import static calculator.util.Const.NUMERIC_REGEX;
import static calculator.util.Const.STRING_ERROR_MESSAGE;
import static calculator.util.Const.STRING_REGEX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelimiterSet {

    private final Set<String> delimiterSet;

    public DelimiterSet() {
        this.delimiterSet = new HashSet<>();
        init();
    }

    private void init() {
        delimiterSet.add(COMMA);
        delimiterSet.add(COLON);
    }

    public void addAll(List<String> delimiters) {
        for (String delimiter : delimiters) {
            validateDelimiter(delimiter);
            delimiterSet.add(delimiter);
        }
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(NUMERIC_ERROR_MESSAGE);
        }
        if (delimiter.matches(STRING_REGEX)) {
            throw new IllegalArgumentException(STRING_ERROR_MESSAGE);
        }
    }

    public boolean hasCustom() {
        return delimiterSet.size() > DEFAULT_DELIMITER_SIZE;
    }

    public String getSplitForm() {
        return String.join(DELIMITER_JOINER, delimiterSet);
    }
}
