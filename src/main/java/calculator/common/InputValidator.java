package calculator.common;

import static calculator.common.Constants.DELIMITER;
import static calculator.common.Constants.DELIMITER_IDX;
import static calculator.common.Constants.FIRST_IDX;
import static calculator.common.Constants.SLASH;

public class InputValidator {

    public static Boolean isCustomSeparator (String input) {
        return input.startsWith(SLASH) && input.charAt(DELIMITER_IDX) == DELIMITER;
    }

    public static Boolean startNumber (String input) {
        return Character.isDigit(input.charAt(FIRST_IDX));
    }
}
