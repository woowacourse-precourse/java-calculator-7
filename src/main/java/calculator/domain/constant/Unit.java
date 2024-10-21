package calculator.domain.constant;

public enum Unit {
    START_INDEX(0),
    CUSTOM_DELIM_LENGTH(1),
    CUSTOM_DELIM_EXPRESSION_LENGTH(CustomDelimBracket.OPEN.get().length()
            + CustomDelimBracket.CLOSE.get().length()
            +CUSTOM_DELIM_LENGTH.value);

    private final int value;

    Unit(int num) {
        value = num;
    }

    public int getValue() {
        return value;
    }
}
