package calculator.global;

public enum CustomDelimiterIndex {

    CUSTOM_DELIMITER_INDEX(2), //커스텀 구분자 인덱스
    CUSTOM_DELIMITER_SUFFIX_START(3), // \n 시작 인덱스
    CUSTOM_DELIMITER_SUFFIX_END(4); // \n 끝 인덱스

    private final int key;

    CustomDelimiterIndex(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
