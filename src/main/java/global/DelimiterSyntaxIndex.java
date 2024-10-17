package global;

public enum DelimiterSyntaxIndex {

    DELIMITER_INDEX(2),
    FIRST_END(3),
    SECOND_END(4),
    DELIMITER_AFTER(5);

    private final int key;

    DelimiterSyntaxIndex(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
