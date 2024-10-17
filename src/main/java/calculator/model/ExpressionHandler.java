package calculator.model;

import java.util.StringTokenizer;

public class ExpressionHandler {

    public String filterExpression(String expression, boolean customDelimiterFlag) {
        if (customDelimiterFlag) {
            expression = expression.substring(5);
        }
        return expression;
    }

    public StringTokenizer tokenizeExpression(String expression) {
        String delimiters = new String(setDelimiter());

        return new StringTokenizer(expression, delimiters);
    }

    // delimiter 클래스에서 불러오는 함수
    private char[] setDelimiter(){
        DelimiterHandler delimiterHandler = new DelimiterHandler();

        return delimiterHandler.getAllDelimiters();
    }

}
