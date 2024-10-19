package calculator.model;

public class TokenChecker {

    private final String delimiters;

    public TokenChecker(String delimiters) {
        this.delimiters = delimiters;
    }

    public boolean isEndingWithDelimiter(int t) {
        return isEven(t);
    }

    public boolean isNumericToken(String token, int t) {
        if (isEven(t)) {
            return verifyNumericToken(token);
        } else {
            return verifyDelimiterToken(token);
        }
    }

    private boolean verifyNumericToken(String token) {
        try {
            if (Integer.parseInt(token) >= 0) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean verifyDelimiterToken(String token) {
        if (delimiters.contains(token)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEven(int t) {
        return t % 2 == 0;
    }

}
