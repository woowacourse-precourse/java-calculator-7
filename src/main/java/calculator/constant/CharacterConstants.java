package calculator.constant;

public final class CharacterConstants {

    public static final char[] CONSTANT_DELIMITER = {',', ':'};
    public static final String CUSTOM_DELIMITER_STARTS_WITH = "//";
    public static final String CUSTOM_DELIMITER_ENDS_WITH = "\\n";
    public static final String INVALID_CUSTOM_DELIMITER_START = "/";
    public static final String INVALID_CUSTOM_DELIMITER_END = "\\";

    private CharacterConstants() {
        throw new UnsupportedOperationException("이 클래스는 인스턴스화 할 수 없습니다");
    }
}
