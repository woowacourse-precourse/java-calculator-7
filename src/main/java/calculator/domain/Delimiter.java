package calculator.domain;

import calculator.validator.DelimiterValidator;

import static calculator.global.constant.DelimiterConstant.PREFIX;
import static calculator.global.constant.DelimiterConstant.SUFFIX;

public class Delimiter {

    private static String separator = ",|:";

    public static String getDelimiter() {
        return separator;
    }

    public static void addCustomDelimiter(String str) {
        str = str.substring(0, 5);
        str = str.replace(PREFIX, "");
        String customDelimiter = str.replace(SUFFIX, "");

        customDelimiter = DelimiterValidator.validRequireEscapeCharacter(customDelimiter);

        separator +=  "|" + customDelimiter;
    }

    public static String removeEnrollmentChar(String str) {
        str = str.replace(PREFIX, "");
        str = str.replace(SUFFIX, "");
        return str.replaceFirst(separator, "");
    }
}
