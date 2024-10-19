package calculator.util;

import static calculator.constant.ErrorMessage.INVALID_INPUT;
import static calculator.constant.ErrorMessage.INVALID_SEPERATOR;
import static calculator.constant.ErrorMessage.REQUIRED_POSITIVE_NUMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    public void isValidInput(String initialInput) {
        if (!initialInput.startsWith("//") && !Character.isDigit(initialInput.charAt(0))) {
            throw new IllegalArgumentException(REQUIRED_POSITIVE_NUMBER);
        }
    }

    public void isValidNumber(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }

    }

    public void isValidSeparatorType(String initialString) {
        Pattern pattern = Pattern.compile("//\\D\\\\n");
        Matcher matcher = pattern.matcher(initialString);

        if (!matcher.find()) {
            throw new IllegalArgumentException(INVALID_SEPERATOR);
        }
    }

    public boolean isSpecialSeparator(Character separator) {
        char[] specialSeparators = {'!', '@', '#', '$', '%', '^', '&', '*', '.'};
        for (char ch : specialSeparators) {
            if (ch == separator) {
                return true;
            }
        }
        return false;
    }
}
