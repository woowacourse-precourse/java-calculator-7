package calculator.regex;

import java.util.Arrays;

public enum MetaCharacter {
    BACKSLASH('\\'),
    CARET('^'),
    PIPE('|'),
    PERIOD('.'),
    DOLLAR('$'),
    QUESTION_MARK('?'),
    ASTERISK('*'),
    PLUS('+'),
    OPEN_PARENTHESIS('('),
    CLOSE_PARENTHESIS(')'),
    OPEN_SQUARE_BRACKET('['),
    OEPN_CURLY_BRACKET('{');

    private final char value;

    MetaCharacter(final char value) {
        this.value = value;
    }

    public static boolean isMetaCharacter(char character) {
        return Arrays.stream(MetaCharacter.values())
                .anyMatch(c -> c.value == character);
    }

}
