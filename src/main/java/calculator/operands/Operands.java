package calculator.operands;

import java.util.ArrayList;
import java.util.List;

public abstract class Operands<E extends Number> {

    protected final List<E> data;

    Operands() {
        this.data = new ArrayList<>();
    }

    public abstract boolean validate(String operand);

    public abstract void addOperand(String operand);

}
