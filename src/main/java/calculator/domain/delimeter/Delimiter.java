package calculator.domain.delimeter;

import static calculator.constant.ExceptionMessage.DELIMITER_NULL_OR_EMPTY;
import static calculator.constant.ExceptionMessage.DELIMITER_RESERVED_CHARACTER;

public class Delimiter {
    private static final String RESERVED_PREFIX = "//";
    private static final String RESERVED_SUFFIX = "\n";

    private final String value;

    private Delimiter(String value) {
        validateNotNullOrEmpty(value);
        validateNotReservedCharacters(value);
        this.value = value;
    }

    public static Delimiter from(String value) {
        return new Delimiter(value);
    }

    private static void validateNotNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(DELIMITER_NULL_OR_EMPTY.message());
        }
    }

    private static void validateNotReservedCharacters(String value) {
        if (value.contains(RESERVED_PREFIX) || value.contains(RESERVED_SUFFIX)) {
            throw new IllegalArgumentException(DELIMITER_RESERVED_CHARACTER.message());
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delimiter delimiter = (Delimiter) o;
        return value.equals(delimiter.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
