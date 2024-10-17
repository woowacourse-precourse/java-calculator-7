package global;

public enum DelimiterSyntaxIndex {

    SPLITTER_INDEX(2),
    FIRST_END(3),
    SECOND_END(4);

    private final int key;

    DelimiterSyntaxIndex(int i) {
        this.key = i;
    }

    public int getKey() {
        return key;
    }
}
