package calculator.model.token;

public class CustomDelimiterToken {
    private String token;

    public CustomDelimiterToken() {

    }

    public CustomDelimiterToken(String token) {
        this.token = token;
    }

    public boolean isNull() {
        return token == null;
    }

    public String extractDelimiter() {
        return token.substring(2);
    }

    // 토큰 검증 한번 더 해야함


    @Override
    public String toString() {
        return token;
    }
}
