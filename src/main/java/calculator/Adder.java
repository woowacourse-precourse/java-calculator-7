package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Adder {

    private final Set<String> delimiters;
    private final List<String> operands;


    public Adder(List<String> operands) {
        this(Set.of(), operands);
    }

    public Adder(Set<String> delimiters, List<String> customOperands) {
        Expression.checkDelimitersConstraints(delimiters);
        Expression.checkOperandsConstraints(customOperands);

        this.delimiters = new HashSet<>(Set.of(",", ":"));
        this.delimiters.addAll(delimiters);

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
