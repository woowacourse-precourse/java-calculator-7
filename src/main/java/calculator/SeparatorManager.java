package calculator;

import static calculator.Constants.*;

import java.util.HashSet;
import java.util.Set;

public class SeparatorManager {
    private final Set<String> separators;

    public SeparatorManager() {
        separators = new HashSet<>();
        separators.add(DEFAULT_SEPARATOR_COMMA);
        separators.add(DEFAULT_SEPARATOR_COLON);
    }

    public Set<String> getSeparators() {
        return separators;
    }

    public void save(String separatorCandidate) {
        validate(separatorCandidate);
        separators.add(separatorCandidate);
    }

    public void validate(String separatorCandidate) {
        if (separatorCandidate == null || separatorCandidate.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_SEPARATOR);
        }

        if (separatorCandidate.length() != 1) {
            throw new IllegalArgumentException(ERROR_ONE_CHAR_SEPARATOR);
        }

        char separator = separatorCandidate.charAt(0);
        if ((int) separator > ASCII_MAX) {
            throw new IllegalArgumentException(ERROR_ASCII_ONLY);
        }

        if ((int) separator <= CONTROL_CHAR_MAX || (int) separator == DEL_CHAR) {
            throw new IllegalArgumentException(ERROR_CONTROL_CHAR);
        }

        if (Character.isWhitespace(separator) && (int) separator != SPACE_CHAR) {
            throw new IllegalArgumentException(ERROR_WHITESPACE);
        }

        if ((int) separator >= DIGIT_MIN && (int) separator <= DIGIT_MAX) {
            throw new IllegalArgumentException(ERROR_NUMERIC_SEPARATOR);
        }
    }
}
