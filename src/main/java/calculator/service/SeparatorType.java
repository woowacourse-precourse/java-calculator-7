package calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SeparatorType {

    COMMA(",", true),
    COLON(":", true),

    BLANK(" ", false),
    NEW_LINE("\n", false),

    PLUS("+", false),
    MINUS("-", false),
    MULTIPLY("*", false),
    DIVIDE("/", false),
    MODULO("%", false),
    FACTORIAL("!", false),
    ROOT("√", false),
    PI("π", false),
    SQUARE("^", false),
    EQUALS("=", false),
    POINT(".", false),
    OPEN_BRACKET("(", false),
    CLOSE_BRACKET(")", false),
    OPEN_BRACE("{", false),
    CLOSE_BRACE("}", false);

    private final String value;
    private final boolean isPermitted;

    SeparatorType(String value, boolean isPermitted) {
        this.value = value;
        this.isPermitted = isPermitted;
    }

    public static List<String> getDefaults() {
        return Arrays.stream(values())
                .filter(SeparatorType::isPermitted)
                .map(SeparatorType::getValue)
                .collect(Collectors.toList());
    }

    public static boolean isPermitted(String value) {
        try {
            return valueOf(value).isPermitted;
        } catch (IllegalArgumentException e) {
            return true;
        }
    }

    public String getValue() {
        return value;
    }

    public boolean isPermitted() {
        return isPermitted;
    }
}
