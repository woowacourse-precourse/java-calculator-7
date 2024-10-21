package calculator.operands;

import java.util.ArrayList;
import java.util.List;

public abstract class Operands<E extends Number> {

    public static final String ZERO = "0";
    protected final List<E> data;

    protected Operands() {
        this.data = new ArrayList<>();
    }

    public List<E> getData() {
        return this.data;
    }

    public abstract Class<E> getType();

    public abstract boolean validate(String operand);

    public abstract void addOperand(String operand);

}
