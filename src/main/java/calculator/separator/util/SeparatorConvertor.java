package calculator.separator.util;

import calculator.constant.ErrorMessage;
import calculator.separator.constant.RegexConstant;

import java.util.stream.IntStream;

public class SeparatorConvertor {
    public static String replaceEscape(String separator) {
        return separator.replace(RegexConstant.SINGLE_BACK_SLASH,
                RegexConstant.DOUBLE_BACK_SLASH);
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
        return IntStream.range(0, input.length() - RegexConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX)
                .filter((index) -> isMatchPattern(input, index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.UNEXPECTED_ERROR));
    }
    private static boolean isMatchPattern(String input, int index) {
        return Character.isDigit(input.charAt(index + 1)) && input.charAt(index) == 'n';
    }
    private static int slashNextLineEndWithIndex(String input) {
        return findSlashNextLine(input) - RegexConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX;
    }
    private static int slashNextLineStartWithIndex(String input) {
        return findSlashNextLine(input) + RegexConstant.EXTRACT_SLASH_NEXT_LINE_ADD_INDEX;
    }
    private static int forwardSlashStartWithIndex(String input) {
        return input.indexOf(RegexConstant.FORWARD_SLASH) + RegexConstant.EXTRACT_START_WITH_ADD_INDEX;
    }
}
