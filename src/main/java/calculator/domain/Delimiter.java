package calculator.domain;

import calculator.validator.DelimiterValidator;
import calculator.validator.StringValidator;

import static calculator.global.constant.DelimiterConstant.*;


public class Delimiter {

    private static final String EMPTY_STRING = "";
    private static final String DELIMITER_SEPARATOR = "|";

    private static String delimiter = ",|:";

    public static String getDelimiter() {
        return delimiter;
    }

    public static void addCustomDelimiter(String str) {
        if (!DelimiterValidator.hasCustomDelimiter(str)) {
            return;
        }
        String customDelimiter = extractCustomDelimiter(str);
        validateCustomDelimiter(customDelimiter);
        addDelimiter(escapeSpecialCharacters(customDelimiter));
    }

    public static String removeEnrollmentString(String str) {
        if (!DelimiterValidator.hasCustomDelimiter(str)) {
            return str;
        }
        str = removePrefixAndSuffix(str);
        return str.replaceFirst(delimiter, EMPTY_STRING);
    }

    private static String removePrefixAndSuffix(String str) {
        str = str.replace(PREFIX, EMPTY_STRING);
        str = str.replace(SUFFIX, EMPTY_STRING);
        return str;
    }

    private static String extractCustomDelimiter(String str) {
        int startIndex = str.indexOf(PREFIX) + PREFIX.length();
        int endIndex = str.indexOf(SUFFIX);
        return str.substring(startIndex, endIndex);
    }

    private static void addDelimiter(String customDelimiter) {
        delimiter += DELIMITER_SEPARATOR + customDelimiter;
    }

    private static String escapeSpecialCharacters(String customDelimiter) {
        return customDelimiter.replaceAll(ESCAPE_REQUIRED_REGEX, ESCAPE_REPLACE_CHAR);
    }

    private static void validateCustomDelimiter(String customDelimiter) {
        StringValidator.validateCustomDelimiterFormat(customDelimiter);
        DelimiterValidator.validateCustomDelimiterLength(customDelimiter);
    }
}