package calculator.operator;

import calculator.arithmeticUnit.ArithmeticOperation;

public class Operator {
    private final Separator separator;
    private final ArithmeticOperation arithmeticOperation;

    public Operator(Separator separator, ArithmeticOperation arithmeticOperation) {
        this.separator = separator;
        this.arithmeticOperation = arithmeticOperation;
    }

    public Operand execute(Operand left, Operand right) {
        return arithmeticOperation.execute(left, right);
    }

    public Separator getSeparator() {
        return separator;
    }

    public String getSymbol() {
        return separator.getSymbol();
    }
}
