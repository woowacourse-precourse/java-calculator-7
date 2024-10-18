package delimiter;

import java.util.Objects;

public class Delimiter {

    private static final String POSITIVE_NUMBER_REGEX = "^(\\+?)\\d*$";

    private final String delimiter;

    public Delimiter(final String delimiter) {
        validateDelimiter(delimiter);

        this.delimiter = delimiter;
    }

    public boolean matches(final String totalRegex) {
        return delimiter.matches(totalRegex);
    }

    private void validateDelimiter(final String delimiter) {
        checkIfOnlyLetters(delimiter);
    }

    private void checkIfOnlyLetters(final String delimiter) {
        if (delimiter.matches(POSITIVE_NUMBER_REGEX)) {
            throw new IllegalArgumentException("구분자는 숫자로만 이루어질 수 없습니다. 문자를 포함하세요.");
        }
    }

    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delimiter delimiter1 = (Delimiter) o;
        return Objects.equals(delimiter, delimiter1.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }
}
