package calculator.service.separator;

import java.util.Arrays;

public enum UnsupportedSeparatorType {

    BLANK(" ", "인식되지 않는 구분자"),
    NEW_LINE("\n", "인식되지 않는 구분자"),

    PLUS("+", "수학적 기호"),
    MINUS("-", "수학적 기호"),
    MULTIPLY("*", "수학적 기호"),
    DIVIDE("/", "수학적 기호"),
    MODULO("%", "수학적 기호"),
    FACTORIAL("!", "수학적 기호"),
    ROOT("√", "수학적 기호"),
    PI("π", "수학적 기호"),
    EQUALS("=", "수학적 기호"),
    SQUARE("^", "수학적 기호"),
    POINT(".", "수학적 기호"),
    OPEN_BRACKET("(", "수학적 기호"),
    CLOSE_BRACKET(")", "수학적 기호"),
    OPEN_BRACE("{", "수학적 기호"),
    CLOSE_BRACE("}", "수학적 기호");

    private final String value;
    private final String reason;

    UnsupportedSeparatorType(String value, String reason) {
        this.value = value;
        this.reason = reason;
    }

    public static boolean isUnsupportedSeparator(String value) {
        return Arrays.stream(values())
                .noneMatch(separator -> separator.getValue().equals(value));
    }

    public static String getReason(String value) {
        return Arrays.stream(values())
                .filter(separator -> separator.getValue().equals(value))
                .findFirst()
                .map(UnsupportedSeparatorType::getReason)
                .orElse("인식되지 않는 구분자");
    }

    public String getValue() {
        return value;
    }

    public String getReason() {
        return reason;
    }
}
