package calculator.domain;

import calculator.validator.DelimiterValidator;
import calculator.validator.StringValidator;

import static calculator.global.constant.DelimiterConstant.PREFIX;
import static calculator.global.constant.DelimiterConstant.SUFFIX;

public class Delimiter {

    private static String delimiter = ",|:";

    public static String getDelimiter() {
        return delimiter;
    }

    public static void addCustomDelimiter(String str) {
        str = str.substring(0, str.lastIndexOf(SUFFIX)+2);
        str = str.replace(PREFIX, "");
        String customDelimiter = str.replace(SUFFIX, "");

        customDelimiter = DelimiterValidator.validateRequireEscapeCharacter(customDelimiter);
        StringValidator.validateCustomDelimiterFormat(customDelimiter);
        DelimiterValidator.validateCustomDelimiterLength(customDelimiter);

        delimiter +=  "|" + customDelimiter;
    }

    public static String removeEnrollmentString(String str) {
        if (str.length() <= 5) {
            return str;
        }

        str = str.replace(PREFIX, "");
        str = str.replace(SUFFIX, "");
        return str.replaceFirst(delimiter, "");
    }
}
