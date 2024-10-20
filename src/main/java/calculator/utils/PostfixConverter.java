package calculator.utils;

import java.util.Stack;

public class PostfixConverter {
    private Stack<String> stack;
    private StringBuilder postfixExpression;

    public PostfixConverter() {
        this.stack = new Stack<>();
        this.postfixExpression = new StringBuilder();
    }

    public String convert(String expression) {
        for (char ch : expression.toCharArray()) {
            makePostfixExpression(ch);
        }
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }
        return postfixExpression.toString();
    }

    private void makePostfixExpression(char ch) {
        if (Character.isDigit(ch)) {
            postfixExpression.append(ch);
        }
        if (!Character.isDigit(ch) && stack.isEmpty()) {
            postfixExpression.append(" ");
            stack.push(String.valueOf(ch));
        } else if (!Character.isDigit(ch) && !stack.isEmpty()) {
            String popSeparator = stack.pop();
            postfixExpression.append(popSeparator);
            stack.push(String.valueOf(ch));
        }
    }

    public void clear() {
        stack.clear();
        postfixExpression = new StringBuilder();
    }
}
