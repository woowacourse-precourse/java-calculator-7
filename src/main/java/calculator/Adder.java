package calculator;

import java.util.ArrayList;
import java.util.List;

public class Adder {

    private final List<String> operands;


    public Adder(List<String> operands) {
        Expression.checkOperandsConstraints(operands);

        this.operands = new ArrayList<>(operands);
    }

    public Adder(Expression expression) {
        this(expression.getOperands());
    }

    public int sum() {
        int sum = 0;

        for (String operand : operands) {
            sum += Integer.parseInt(operand);
        }
        return sum;
    }


}
