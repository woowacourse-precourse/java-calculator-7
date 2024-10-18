package calculator.model;

import java.util.LinkedList;

public class Expression {
    private final LinkedList<Object> tokenList;

    public Expression() {
        tokenList = new LinkedList<>();
    }

    public void addToken(Object token) {
        tokenList.add(token);
    }

    public LinkedList<Object> getExpression() {
        return tokenList;
    }
}
