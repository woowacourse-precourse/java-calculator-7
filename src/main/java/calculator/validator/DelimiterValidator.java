package calculator.validator;

import static calculator.global.constant.DelimiterConstant.*;

public class DelimiterValidator {

    public static boolean hasCustomDelimiter(String str) {
        if (str.length() >= 5) {
            str = str.substring(0, 5);

            return isCustomDelimiter(str);
        }

        return false;
    }

    private static boolean isCustomDelimiter(String str) {
        return str.startsWith(PREFIX) && str.endsWith(SUFFIX);
    }

    public static String validRequireEscapeCharacter(String customDelimiter) {
        if (customDelimiter.equals("|")) {
            customDelimiter = "\\" + customDelimiter;
        }
        return customDelimiter;
    }
}
