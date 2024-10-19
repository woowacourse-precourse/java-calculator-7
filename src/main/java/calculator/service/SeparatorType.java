package calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SeparatorType {

    COMMA(",", true, "기본 구분자"),
    COLON(":", true, "기본 구분자"),

    BLANK(" ", false, "인식되지 않는 구분자"),
    NEW_LINE("\n", false, "인식되지 않는 구분자"),

    PLUS("+", false, "수학적 기호"),
    MINUS("-", false, "수학적 기호"),
    MULTIPLY("*", false, "수학적 기호"),
    DIVIDE("/", false, "수학적 기호"),
    MODULO("%", false, "수학적 기호"),
    FACTORIAL("!", false, "수학적 기호"),
    ROOT("√", false, "수학적 기호"),
    PI("π", false, "수학적 기호"),
    EQUALS("=", false, "수학적 기호"),
    SQUARE("^", false, "수학적 기호"),
    POINT(".", false, "수학적 기호"),
    OPEN_BRACKET("(", false, "수학적 기호"),
    CLOSE_BRACKET(")", false, "수학적 기호"),
    OPEN_BRACE("{", false, "수학적 기호"),
    CLOSE_BRACE("}", false, "수학적 기호");

    private final String value;
    private final boolean isPermitted;
    private final String reason;

    SeparatorType(String value, boolean isPermitted, String reason) {
        this.value = value;
        this.isPermitted = isPermitted;
        this.reason = reason;
    }

    public static List<String> getDefaults() {
        return Arrays.stream(values())
                .filter(SeparatorType::isPermitted)
                .map(SeparatorType::getValue)
                .collect(Collectors.toList());
    }

    public static boolean isPermitted(String value) {
        return Arrays.stream(values())
                .filter(separator -> separator.getValue().equals(value))
                .findFirst()
                .map(SeparatorType::isPermitted)
                .orElse(true);
    }

    public static String getReason(String value) {
        return Arrays.stream(values())
                .filter(separator -> separator.getValue().equals(value))
                .findFirst()
                .map(SeparatorType::getReason)
                .orElse("인식되지 않는 구분자");
    }

    public String getValue() {
        return value;
    }

    public String getReason() {
        return reason;
    }

    public boolean isPermitted() {
        return isPermitted;
    }
}
