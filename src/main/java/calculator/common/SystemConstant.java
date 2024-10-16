package calculator.common;

public enum SystemConstant {
    MAX_CUSTOM_DELIMITER_COUNT(1),
    EMPTY_STRING("")
    ;
    private final Object value;

    SystemConstant(Object value) {
        this.value = value;
    }

    public static int maxCustomDelimiterCount() {
        return (int) MAX_CUSTOM_DELIMITER_COUNT.value;
    }

    public static String emptyString() {
        return (String) EMPTY_STRING.value;
    }
}
