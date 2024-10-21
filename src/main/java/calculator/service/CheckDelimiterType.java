package calculator.service;

public class CheckDelimiterType {

    // 기본 구분자 형식인지 판별하기 위한 정규식
    private static final String BASIC_DELIMITER_PATTERN = "(-)*([0-9])+([,|:])(.*)";

    // 기본 구분자 형식인지 판별하기 위한 메소드
    public static Boolean isBasicDelimiter(String input) {
        return input.matches(BASIC_DELIMITER_PATTERN);
    }
}
