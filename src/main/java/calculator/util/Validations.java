package calculator.util;

import static calculator.model.Mode.WRONG_DELI;
import static calculator.util.Constants.*;
import static calculator.util.Exceptions.*;

import calculator.model.Mode;

public class Validations {
    public static void validateWrongDelimiter(Mode mode) {
        if (mode == WRONG_DELI) {
            throw new IllegalArgumentException(WRONG_INPUT_DELIMITER.getMsg());
        }
    }

    public static void validatePositiveNumber(String value) {
        if (value.equals(ZERO)
                || value.equals(MINUS)) {
            throw new IllegalArgumentException(WRONG_INPUT_NUMBER.getMsg());
        }
    }

    public static void validateIfCustomDeliEnds(int customDeliEndIdx) {
        if (customDeliEndIdx == DEFAULT_CUSTOM_DELI_END_IDX) {
            throw new IllegalArgumentException(CUSTOM_DELI_NOT_ENDS.getMsg());
        }
    }

    public static void validateCustomDelimiter(String customDeli) {
        for (String resWord : RESERVED_WORDS) {
            if (customDeli.contains(resWord)
                    || customDeli.matches(NUMBER_REGEX)) {
                throw new IllegalArgumentException(WRONG_CUSTOM_DELIMITER.getMsg());
            }
        }
    }
}
