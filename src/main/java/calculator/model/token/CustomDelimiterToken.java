package calculator.model.token;

public class CustomDelimiterToken {
    private String token;

    public CustomDelimiterToken(String token) {
        this.token = token;
    }

    public String extractDelimiter() {
        return token.substring(2);
    }

    @Override
    public String toString() {
        return token;
    }
}
