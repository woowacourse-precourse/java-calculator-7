package calculator.separator.util;

import calculator.constant.ErrorMessage;
import calculator.separator.constant.RegexConstant;
import calculator.separator.domain.DefaultSeparator;

import java.util.stream.IntStream;

public class SeparatorConvertor {
    public static String addCustomSeparator(String customSeparator) {
        return replaceEscape(customSeparator);
    }
    public static String defaultSeparator() {
        return DefaultSeparator.getDefaultSeparator();
    }
    public static int slashNextLineEndWithIndex(String input) {
        return findSlashNextLine(input) - RegexConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX;
    }
    public static int slashNextLineStartWithIndex(String input) {
        return findSlashNextLine(input) + RegexConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX;
    }
    public static int forWardSlashStartWithIndex(String input) {
        return input.indexOf(RegexConstant.FORWARD_SLASH) + RegexConstant.EXTRACT_START_WITH_ADD_INDEX;
    }
    public static String createCustomSeparator(String input, int startWith, int endWith) {
        return input.substring(startWith, endWith);
    }
    public static String createNumber(String input, int startWith) {
        return input.substring(startWith);
    }
    private static int findSlashNextLine(String input) {
        return IntStream.range(0, input.length() - RegexConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX)
                .filter((index) -> isEqualsPattern(input, index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR));
    }
    private static boolean isEqualsPattern(String input, int index) {
        return Character.isDigit(input.charAt(index + 1)) && input.charAt(index) == 'n';
    }
    private static String replaceEscape(String separator) {
        return separator.replace(RegexConstant.SINGLE_BACK_SLASH,
                RegexConstant.DOUBLE_BACK_SLASH);
    }
}
