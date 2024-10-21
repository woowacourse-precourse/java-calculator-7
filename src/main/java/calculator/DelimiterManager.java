package calculator;

/** 구분자와 관련된 속성, 기능을 관리하는 클래스 */
public class DelimiterManager {

    /**
     * DELIMITER_PREFIX : 구분자 섹션의 접두사
     * DELIMITER_SUFFIX : 구분자 섹션의 접미사
     * MAX_LEN_DELIMITERS : 구분자들의 최대 갯수
     * CUSTOM_DELIMITER_LEN : 사용자 정의 구분자 길이
     * lenOfPrefix : 구분자 섹션 접두사의 길이
     * lenOfSuffix : 구분자 섹션 접미사의 길이
     * customDelimiter : 사용자 정의 구분자
     * delimiters : 구분자들
     * count : 구분자들의 개수
     */
    static final String DELIMITER_PREFIX = "//";
    static final String DELIMITER_SUFFIX = "\\n";
    private static final int MAX_LEN_DELIMITERS = 3;
    public static final int CUSTOM_DELIMITER_LEN = 1;
    private int lenOfPrefix;
    private int lenOfSuffix;
    private char customDelimiter;
    private String delimiters;
    private int count;

    public DelimiterManager() {
        lenOfPrefix = DELIMITER_PREFIX.length();
        lenOfSuffix = DELIMITER_SUFFIX.length();
        delimiters = ",:";
        count = 2;
    }

    /** 멤버 변수 customdelimiter의 getter */
    public char getCustomDelimiter() {
        return customDelimiter;
    }

    /** 멤버 변수 lenOfPrefix의 getter */
    public int getLenOfPrefix() {
        return lenOfPrefix;
    }

    /** 멤버 변수 lenOfSuffix의 getter */
    public int getLenOfSuffix() {
        return lenOfSuffix;
    }

    /** 멤버 변수 delimiters의 getter */
    public String getDelimiters() {
        return delimiters;
    }

    /** 멤버 변수 customdelimiter의 setter */
    public void setCustomDelimiter(char customDelimiter) {
        this.customDelimiter = customDelimiter;
        addDelimiter(Character.toString(customDelimiter));
    }

    private void addDelimiter(String delimiter) {

        isDelimiterLimitExceeded();
        isDelimiterExists(delimiter);

        delimiters += delimiter;
        count++;
    }

    private void isDelimiterLimitExceeded() {
        if (count >= MAX_LEN_DELIMITERS) {
            throw new IllegalArgumentException("Only one custom delimiter is allowed.");
        }
    }

    private void isDelimiterExists(String customDelimiter) {
        if (delimiters.contains(customDelimiter)) {
            throw new IllegalArgumentException("Custom delimiter cannot be a default delimiter (',' or ':').");
        }
    }
}