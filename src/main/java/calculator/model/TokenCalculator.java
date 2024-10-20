package calculator.model;

import java.util.StringTokenizer;

public class TokenCalculator {

    private final StringTokenizer tokenizedExpression;
    private final String delimiters;

    public TokenCalculator(StringTokenizer tokenizedExpression, String delimiters) {
        this.tokenizedExpression = tokenizedExpression;
        this.delimiters = delimiters;
    }

    public int getSumOfTokens() {
        TokenChecker tokenChecker = new TokenChecker(delimiters);

        int sum = 0;
        int tokenCounter = -1;
        while (tokenizedExpression.hasMoreTokens()) {
            String token = tokenizedExpression.nextToken();
            tokenCounter++;

            if (tokenChecker.isNumericToken(token, tokenCounter)) {
                sum += Integer.parseInt(token);
            }
        }

        if (tokenChecker.isDelimiterEnding(tokenCounter)) {
            throw new IllegalArgumentException();
        }

        return sum;
    }

}
