package calculator.domain.vo.delimiter;

import static calculator.infrastructure.exception.ErrorCode.*;

import java.util.Objects;

public class Delimiter {

    private final String value;

    private Delimiter(final String value) {
        validate(value);
        this.value = value;
    }

    protected void validate(final String value) {
        if (value == null || value.length() != 1) {
            throw new IllegalArgumentException(INVALID_DELIMITER.getMessage());
        }
    }

    public static Delimiter from(final String value) {
        return new Delimiter(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Delimiter)) {
            return false;
        }
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(delimiter, delimiter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.format("Delimiter = '%s'", value);
    }
}
