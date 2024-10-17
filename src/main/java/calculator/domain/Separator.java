package calculator.domain;

import calculator.validator.SeparatorValidator;

import static calculator.global.constant.SeparatorConstant.PREFIX;
import static calculator.global.constant.SeparatorConstant.SUFFIX;

public class Separator {

    private static String separator = ",|:";

    public static String getSeparator() {
        return separator;
    }

    public static void addCustomSeparator(String str) {
        str = str.substring(0, 5);
        str = str.replace(PREFIX, "");
        String customSeparator = str.replace(SUFFIX, "");

        customSeparator = SeparatorValidator.validRequireEscapeCharacter(customSeparator);

        separator +=  "|" + customSeparator;
    }

    public static String removeEnrollmentChar(String str) {
        str = str.replace(PREFIX, "");
        str = str.replace(SUFFIX, "");
        return str.replaceFirst(separator, "");
    }
}
