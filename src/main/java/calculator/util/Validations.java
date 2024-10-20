package calculator.util;

import static calculator.util.Constants.*;
import static calculator.util.Exceptions.*;

import calculator.model.DelimiterMode;
import java.util.stream.Stream;

public class Validations {
    private static final String[] RESERVED_WORDS = Stream
            .of(DEFAULT_DELIMITERS,
                    new String[]{MINUS, CUSTOM_DELI_START_SIGNAL, CUSTOM_DELI_END_SIGNAL})
            .flatMap(Stream::of)
            .toArray(String[]::new);

    public static void validateCustomDeliEnds(int customDeliEndIdx) {
        if (customDeliEndIdx == DEFAULT_CUSTOM_DELI_END_IDX) {
            throw new IllegalArgumentException(CUSTOM_DELI_NOT_ENDS.getMsg());
        }
    }

    public static void validateCorrectCustomDelimiter(String customDeli) {
        for (String resWord : RESERVED_WORDS) {
            if (customDeli.contains(resWord)
                    || customDeli.matches(NUMBER_REGEX)
                    || customDeli.isEmpty()) {
                throw new IllegalArgumentException(WRONG_CUSTOM_DELIMITER.getMsg());
            }
        }
    }

    public static void validateCorrectDelimiter(DelimiterMode mode) {
        if (mode == DelimiterMode.WRONG) {
            throw new IllegalArgumentException(WRONG_DELIMITER.getMsg());
        }
    }

    public static void validatePositiveNumber(String value) {
        if (value.equals(ZERO)
                || value.startsWith(MINUS)) {
            throw new IllegalArgumentException(WRONG_NUMBER.getMsg());
        }
    }

    public static void validateNumberMaxLength(String number) {
        if (number.length() > INTEGER_PARSE_MAX_LENGTH) {
            throw new IllegalArgumentException(EXCEED_MAX_NUMBER_LENGTH.getMsg());
        }
    }
}
