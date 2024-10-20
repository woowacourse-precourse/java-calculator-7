package calculator.constant;

public enum CalConst {
    MINIMUM_LENGTH_IF_EXIST_CUSTOM_SEPARATOR(5),
    START_INDEX_OF_CALCULATING(5),
    END_INDEX_OF_CUSTOM_SEPARATOR(3),
    INDEX_OF_CUSTOM_SEPARATOR(2),
    ;

    private final int value;

    CalConst(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
