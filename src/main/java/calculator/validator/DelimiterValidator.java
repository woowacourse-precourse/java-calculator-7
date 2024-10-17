package calculator.validator;

import static calculator.global.constant.DelimiterConstant.*;

public class DelimiterValidator {

    public static boolean hasCustomDelimiter(String str) {
        if (str.length() >= 5) {
            str = str.substring(0, 5);

            return str.startsWith(PREFIX) && str.endsWith(SUFFIX);
        }

        return false;
    }

    public static String validRequireEscapeCharacter(String customDelimiter) {
        if (customDelimiter.equals("|")) {
            customDelimiter = "\\" + customDelimiter;
        }
        return customDelimiter;
    }
}
