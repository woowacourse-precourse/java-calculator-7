package calculator;

import calculator.operator.Operator;
import calculator.operator.OperatorRepository;
import calculator.utils.PostfixConverter;

import java.util.Stack;

public class Calculator {

    private PostfixConverter postfixConverter;
    private OperatorRepository operatorRepository;
    private Stack<Integer> numberStack;

    public Calculator(OperatorRepository operatorRepository) {
        this.postfixConverter = new PostfixConverter();
        this.operatorRepository = operatorRepository;
        this.numberStack = new Stack<>();
    }

    public int calculate(String expression) {
        String postfixExpression = postfixConverter.convert(expression); // 후위표기식으로 변경
        return calculateProcess(postfixExpression);
    }

    private int calculateProcess(String postfixExpression) {
        if (postfixExpression.isEmpty()) {
            return 0;
        }
        StringBuilder number = new StringBuilder();
        for (char ch : postfixExpression.toCharArray()) {
            if (Character.isDigit(ch)) {
                number.append(ch);
                continue;
            }
            if (ch == ' ') { // 공백인 경우(수 구분 용도)
                numberStack.push(Integer.parseInt(number.toString()));
                number = new StringBuilder();
                continue;
            }
            if (!Character.isDigit(ch)) { // 구분자인 경우
                numberStack.push(Integer.parseInt(number.toString()));
                number = new StringBuilder();
                Operator operator = operatorRepository.getOperator(String.valueOf(ch));
                int number2 = numberStack.pop();
                int number1 = numberStack.pop();
                numberStack.push(operator.compute(number1, number2));
            }
        }
        if (!number.isEmpty()) { // postExpression의 마지막 요소가 수인 경우
            numberStack.push(Integer.parseInt(number.toString()));
        }
        return numberStack.pop();
    }
}
