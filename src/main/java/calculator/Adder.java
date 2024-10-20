package calculator;

import java.util.ArrayList;
import java.util.List;

public class Adder {

    private final Delimiters delimiters;
    private final List<String> operands;


    public Adder(List<String> operands) {
        this(Delimiters.of(), operands);
    }

    public Adder(Delimiters delimiters, List<String> customOperands) {
        Delimiters.check(delimiters);
        Expression.checkOperandsConstraints(customOperands);

        this.delimiters = delimiters;
        this.operands = new ArrayList<>(customOperands);
    }

    public Adder(Expression expression) {
        this(expression.getDelimiters(), expression.getOperands());
    }

    public int sum() {
        int sum = 0;

        for (String operand : operands) {
            sum += Integer.parseInt(operand);
        }
        return sum;
    }


}
