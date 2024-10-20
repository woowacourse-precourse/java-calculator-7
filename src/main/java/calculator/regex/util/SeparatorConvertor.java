package calculator.regex.util;

import calculator.validator.constant.ErrorMessage;
import calculator.regex.constant.SeparatorConvertorConstant;

import java.util.stream.IntStream;

public class SeparatorConvertor {

    public static String replaceRegex(String separator) {
        if (separator.equals(SeparatorConvertorConstant.DOT)) return SeparatorConvertorConstant.DOT_REGEX;
        return separator.replace(SeparatorConvertorConstant.SINGLE_BACK_SLASH,
                SeparatorConvertorConstant.DOUBLE_BACK_SLASH);
    }
    public static String createCustomSeparator(String input) {
        int startWith = forwardSlashStartWithIndex(input);
        int endWith = slashNextLineEndWithIndex(input);
        return input.substring(startWith, endWith);
    }
    public static String createNumber(String input) {
        int startWith = slashNextLineStartWithIndex(input);
        return input.substring(startWith);
    }
    private static int findSlashNextLine(String input) {
        return IntStream.range(0, input.length() - SeparatorConvertorConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX)
                .filter((index) -> isMatchPattern(input, index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR));
    }
    private static boolean isMatchPattern(String input, int index) {
        return Character.isDigit(input.charAt(index + 1)) && input.charAt(index) == 'n';
    }
    private static int slashNextLineEndWithIndex(String input) {
        return findSlashNextLine(input) - SeparatorConvertorConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX;
    }
    private static int slashNextLineStartWithIndex(String input) {
        return findSlashNextLine(input) + SeparatorConvertorConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX;
    }
    private static int forwardSlashStartWithIndex(String input) {
        return input.indexOf(SeparatorConvertorConstant.FORWARD_SLASH) + SeparatorConvertorConstant.EXTRACT_START_WITH_ADD_INDEX;
    }
}
