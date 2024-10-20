package calculator.util.pattern;

import calculator.common.exception.ExceptionFactory;

import java.util.List;
import java.util.regex.Pattern;

import static calculator.common.exception.ExceptionType.CAN_NOT_INSTANTIATE;

public final class PatternUtils {

    public final static Pattern NUMBER_PATTERNS = Pattern.compile("[0-9]");
    public final static String SPLIT_DELIMITER = "|";
    public final static String ESCAPE = "\\";
    private final static List<String> SPECIAL_CHARACTERS = List.of(
            ".", "*", "+", "?", "^", "$", "[", "]", "{", "}", "(", ")", "|"
    );

    private PatternUtils() {
        throw ExceptionFactory.createException(CAN_NOT_INSTANTIATE);
    }

    public static String join(String delimiter, List<String> values) {
        return String.join(delimiter, values);
    }

    public static boolean matchesWithDelimitersIgnoringNumbers(String value, Pattern delimiterPattern) {
        String combinedPattern = String.format("[%s]", NUMBER_PATTERNS + delimiterPattern.pattern());
        return value.matches(combinedPattern + "*");
    }

    public static String escapeSpecialCharacters(String value) {
        for (String specialCharacter : SPECIAL_CHARACTERS) {
            value = value.replace(specialCharacter, "\\" + specialCharacter);
        }
        return value;
    }
}
