package calculator.global;

public enum CustomDelimiterIndex {

    CUSTOM_DELIMITER_INDEX(2),
    CUSTOM_DELIMITER_SUFFIX_START(3),
    CUSTOM_DELIMITER_SUFFIX_END(4);

    private final int key;

    CustomDelimiterIndex(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
