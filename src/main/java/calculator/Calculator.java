package calculator;

import java.util.Stack;

public class Calculator {

    private static final int LOW_PRECEDENCE = 1;
    private static final int HIGH_PRECEDENCE = 2;
    private int result;


    public int getResult() {
        return result;
    }

    public Calculator(String formula) {
        result = calculate(formula);
    }

    private int calculate(String formula) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int num = 0;
        boolean isNumber = false;

        for (int i = 0; i < formula.length(); i++) {
            char currentChar = formula.charAt(i);

            if (Character.isDigit(currentChar)) {
                num = num * 10 + (currentChar - '0');
                isNumber = true;
                continue;
            }

            if (isNumber) {
                numbers.push(num);
                num = 0;
                isNumber = false;
            }

            if (isOperator(currentChar)) {
                processOperator(operators, numbers, currentChar);
            }
        }

        if (isNumber) {
            numbers.push(num);
        }

        while (!operators.isEmpty()) {
            processStacks(numbers, operators);
        }

        return numbers.pop();
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private void processOperator(Stack<Character> operators, Stack<Integer> numbers, char operator) {
        while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(operator)) {
            processStacks(numbers, operators);
        }
        operators.push(operator);
    }

    private int precedence(char operator) {
        if (operator == '*' || operator == '/') return HIGH_PRECEDENCE;
        return LOW_PRECEDENCE;
    }

    private void processStacks(Stack<Integer> numbers, Stack<Character> operators) {
        int b = numbers.pop();
        int a = numbers.pop();
        char op = operators.pop();

        if (op == '+') numbers.push(a + b);
        if (op == '-') numbers.push(a - b);
        if (op == '*') numbers.push(a * b);
        if (op == '/') numbers.push(a / b);
    }

}
