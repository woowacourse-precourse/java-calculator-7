package calculator.model;

import java.util.StringTokenizer;

public class ExpressionHandler {

    private String delimiters;

    public String filterExpression(String expression, boolean customDelimiterFlag) {
        if (customDelimiterFlag) {
            expression = expression.substring(5);
        }
        return expression;
    }

    public StringTokenizer tokenizeExpression(String expression) {
        setDelimiter();
        return new StringTokenizer(expression, delimiters, true);
    }

    public int getSum(StringTokenizer tokenizedExpression) {
        int sum = 0;

        int t = 0;
        while (tokenizedExpression.hasMoreTokens()) {
            String token = tokenizedExpression.nextToken();

            if (checkToken(token, t)) {
                sum += Integer.parseInt(token);
            }
            t++;
        }

        // t가 짝수로 끝났다는 것은 직전이 홀수(구분자)였다는 것
        if (t % 2 == 0){
            throw new IllegalArgumentException();
        }

        return sum;
    }

    // 개선이 필요해보임
    private boolean checkToken(String token, int t) {
        // 짝수면 숫자(양의 정수)여야함
        if (t % 2 == 0) {
            try {
                if (Integer.parseInt(token) >= 0){
                    return true;
                }
                else {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        // 홀수면 delimiters 중 여야함
        else if (delimiters.contains(token)){
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void setDelimiter(){
        DelimiterHandler delimiterHandler = new DelimiterHandler();
        delimiters = delimiterHandler.getAllDelimiters();
    }

}
