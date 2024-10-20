package calculator.model.token;

public class CustomDelimiterToken {

    private final String token;

    private static final int DELIMITER_INDEX = 2;

    public CustomDelimiterToken(String token) {
        this.token = token;
    }

    public String extractDelimiter() {
        return token.substring(DELIMITER_INDEX);
    }

    @Override
    public String toString() {
        return token;
    }
}
