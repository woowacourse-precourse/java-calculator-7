package calculator.common;

import static calculator.common.Constants.DELIMITER;
import static calculator.common.Constants.DELIMITER_IDX;
import static calculator.common.Constants.FIRST_IDX;
import static calculator.common.Constants.SLASH;

public class InputValidator {

    public static Boolean isCustomSeparator (String input) {
        return input.startsWith(SLASH) && input.startsWith(DELIMITER, DELIMITER_IDX);
    }

    public static Boolean isBasicSeparator (String input) {
        return Character.isDigit(input.charAt(FIRST_IDX));
    }
}
