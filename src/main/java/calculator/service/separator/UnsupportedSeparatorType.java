package calculator.service.separator;

import static calculator.util.Constants.MATH;
import static calculator.util.Constants.UNKNOWN;

import java.util.Arrays;

public enum UnsupportedSeparatorType {

    BLANK(" ", UNKNOWN),
    BACKSLASH("\\", UNKNOWN),

    PLUS("+", MATH),
    MINUS("-", MATH),
    MULTIPLY("*", MATH),
    DIVIDE("/", MATH),
    MODULO("%", MATH),
    FACTORIAL("!", MATH),
    ROOT("√", MATH),
    PI("π", MATH),
    EQUALS("=", MATH),
    SQUARE("^", MATH),
    POINT(".", MATH),
    OPEN_BRACKET("(", MATH),
    CLOSE_BRACKET(")", MATH),
    OPEN_BRACE("{", MATH),
    CLOSE_BRACE("}", MATH);

    private final String value;
    private final String reason;

    UnsupportedSeparatorType(String value, String reason) {
        this.value = value;
        this.reason = reason;
    }

    public static boolean isUnsupported(String value) {
        return Arrays.stream(values())
                .anyMatch(separator -> separator.isMatchValue(value));
    }

    public static String getReason(String value) {
        return Arrays.stream(values())
                .filter(separator -> separator.isMatchValue(value))
                .findFirst()
                .map(UnsupportedSeparatorType::getReason)
                .orElse(UNKNOWN);
    }

    private boolean isMatchValue(String inputValue) {
        return value.equals(inputValue);
    }

    public String getReason() {
        return reason;
    }
}
