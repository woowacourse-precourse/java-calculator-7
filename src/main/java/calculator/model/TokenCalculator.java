package calculator.model;

import java.util.StringTokenizer;

public class TokenCalculator {

    private final StringTokenizer tokenizedExpression;
    private final String delimiters;

    public TokenCalculator(StringTokenizer tokenizedExpression, String delimiters) {
        this.tokenizedExpression = tokenizedExpression;
        this.delimiters = delimiters;
    }

    public int getSum() {
        TokenChecker tokenChecker = new TokenChecker(delimiters);

        int sum = 0;
        int t = 0;
        while (tokenizedExpression.hasMoreTokens()) {
            String token = tokenizedExpression.nextToken();

            if (tokenChecker.isNumericToken(token, t)) {
                sum += Integer.parseInt(token);
            }
            t++;
        }

        if (tokenChecker.isEndingWithDelimiter(t)) {
            throw new IllegalArgumentException();
        }

        return sum;
    }

}
