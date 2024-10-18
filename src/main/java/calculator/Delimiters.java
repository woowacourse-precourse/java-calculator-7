package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Delimiters {

    private static final String CONTAINING_ALL_START_REGEX = "^.*(";
    private static final String CONTAINING_ALL_END_REGEX = ").*";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    private final List<Delimiter> delimiters;

    public Delimiters(final List<Delimiter> delimiters) {
        this.delimiters = new ArrayList<>(delimiters);
    }

    public void addDelimiter(final Delimiter delimiter) {
        validateDelimiters(delimiter);

        delimiters.add(delimiter);
    }

    public Delimiters merge(final Delimiters other) {
        return new Delimiters(Stream.of(this.delimiters, other.getDelimiters())
                .flatMap(List::stream)
                .distinct()
                .toList());
    }

    private void validateDelimiters(final Delimiter delimiter) {
        checkIfOtherDelimiterIncluded(delimiter);
        checkIfDefaultDelimiterIncluded(delimiter);
    }

    private void checkIfOtherDelimiterIncluded(final Delimiter delimiter) {
        if (delimiters.contains(delimiter)) {
            throw new IllegalArgumentException("구분자는 다른 커스텀 구분자를 포함할 수 없습니다.");
        }
    }

    private void checkIfDefaultDelimiterIncluded(final Delimiter delimiter) {
        String totalRegex = CONTAINING_ALL_START_REGEX + DEFAULT_DELIMITER_REGEX + CONTAINING_ALL_END_REGEX;
        if (delimiter.matches(totalRegex)) {
            throw new IllegalArgumentException("구분자는 기본 구분자를 포함할 수 없습니다.");
        }
    }

    public List<Delimiter> getDelimiters() {
        return Collections.unmodifiableList(delimiters);
    }
}
