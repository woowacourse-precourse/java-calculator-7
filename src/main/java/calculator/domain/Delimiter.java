package calculator.domain;

import calculator.validator.DelimiterValidator;
import calculator.validator.StringValidator;

import static calculator.global.constant.DelimiterConstant.PREFIX;
import static calculator.global.constant.DelimiterConstant.SUFFIX;
import static calculator.global.constant.DelimiterConstant.ESCAPE_CHAR;
import static calculator.global.constant.DelimiterConstant.ESCAPE_REQUIRED_REGEX;

public class Delimiter {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITER_SEPARATOR = "|";

    private static String delimiter = ",|:";

    public static String getDelimiter() {
        return delimiter;
    }

    public static void addCustomDelimiter(String str) {
        str = str.substring(0, str.lastIndexOf(SUFFIX)+SUFFIX.length());
        str = removePrefixAndSuffix(str);
        String customDelimiter = addEscapeChar(str);
        validateCustomDelimiter(customDelimiter);
        addDelimiter(customDelimiter);
    }

    public static String removeEnrollmentString(String str) {
        if (!DelimiterValidator.hasCustomDelimiter(str)) {
            return str;
        }
        str = removePrefixAndSuffix(str);
        return str.replaceFirst(delimiter, EMPTY_STRING);
    }

    private static void addDelimiter(String customDelimiter) {
        delimiter +=  DELIMITER_SEPARATOR + customDelimiter;
    }

    private static String addEscapeChar(String customDelimiter) {
        if (customDelimiter.matches(ESCAPE_REQUIRED_REGEX)) {
            customDelimiter = ESCAPE_CHAR + customDelimiter;
        }
        return customDelimiter;
    }

    private static void validateCustomDelimiter(String customDelimiter) {
        StringValidator.validateCustomDelimiterFormat(customDelimiter);
        DelimiterValidator.validateCustomDelimiterLength(customDelimiter);
    }

    private static String removePrefixAndSuffix(String str) {
        str = str.replace(PREFIX, EMPTY_STRING);
        str = str.replace(SUFFIX, EMPTY_STRING);
        return str;
    }
}
