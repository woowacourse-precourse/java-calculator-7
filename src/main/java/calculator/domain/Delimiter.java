package calculator.domain;

import calculator.error.ErrorMessage;
import java.util.regex.Pattern;

public class Delimiter {
    private final String value;

    public Delimiter(String value) {
        validate(value);
        this.value = value;
    }

    public boolean doesNotSupport(String delimiterValue) {
        return !value.contains(delimiterValue);
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public String getValue() {
        if (isEmpty()) {
            return value;
        }
        return "[" + Pattern.quote(value) + "]";
    }

    private void validate(String value) {
        if (isNumber(value)) {
            throw new IllegalArgumentException(ErrorMessage.UNSUPPORTED_CUSTOM_DELIMITER_NUMBER.getDescription());
        }
    }

    private boolean isNumber(String value) {
        try {
            int ignored = Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }
}