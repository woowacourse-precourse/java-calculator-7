package calculator.model;

// 문자열에서 커스텀문자열이 적혀있는 부분을 담는 토큰 객체
public class CustomDelimiterToken {

    private final String token;

    private static final int DELIMITER_INDEX = 2;

    public CustomDelimiterToken(String token) {
        this.token = token;
    }

    // 토큰에서 구분자 추출하는 메서드
    public String extractDelimiter() {
        return token.substring(DELIMITER_INDEX);
    }

    @Override
    public String toString() {
        return token;
    }
}
