package calculator.domain.delimiter;

import java.util.Objects;

public record Delimiter(String delimiter) {

    private static final String POSITIVE_NUMBER_REGEX = "^(\\+?)\\d*$";

    public Delimiter {
        validateDelimiter(delimiter);

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

}
