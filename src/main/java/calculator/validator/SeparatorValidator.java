package calculator.validator;

import static calculator.global.constant.SeparatorConstant.*;

public class SeparatorValidator {

    public static boolean hasCustomSeparator(String str) {
        if (str.length() >= 5) {
            str = str.substring(0, 5);

            return str.startsWith(PREFIX) && str.endsWith(SUFFIX);
        }

        return false;
    }

    public static String validRequireEscapeCharacter(String customSeparator) {
        if (customSeparator.equals("|")) {
            customSeparator = "\\" + customSeparator;
        }
        return customSeparator;
    }
}
