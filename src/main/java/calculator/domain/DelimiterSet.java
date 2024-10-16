package calculator.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DelimiterSet {

    private static final String NUMERIC_REGEX = "[0-9]+";
    private static final String STRING_REGEX = "[a-zA-Z가-힣]+";

    private final Set<String> delimiterSet;

    public DelimiterSet() {
        this.delimiterSet = new HashSet<>();
        init();
    }

    private void init() {
        delimiterSet.add(",");
        delimiterSet.add(":");
    }

    public void addAll(List<String> delimiters) {
        for (String delimiter : delimiters) {
            validateDelimiter(delimiter);
            delimiterSet.add(delimiter);
        }
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException("숫자는 구분자로 사용 불가능합니다.");
        }
        if (delimiter.matches(STRING_REGEX)) {
            throw new IllegalArgumentException("문자는 구분자로 사용 불가능합니다.");
        }
    }

    public boolean hasCustom() {
        return delimiterSet.size() > 2;
    }

    public String getSplitForm() {
        return String.join("|", delimiterSet);
    }
}
