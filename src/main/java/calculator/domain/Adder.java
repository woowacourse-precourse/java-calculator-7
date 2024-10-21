package calculator.domain;

public class Adder {

    private final Operands operands;


    public Adder(Operands operands) {
        Operands.check(operands);

        this.operands = operands;
    }

    public Adder(Expression expression) {
        this(expression.getOperands());
    }

    public int sum() {
        int sum = 0;

        for (String operand : operands.toList()) {
            sum += Integer.parseInt(operand);
        }
        return sum;
    }

}
