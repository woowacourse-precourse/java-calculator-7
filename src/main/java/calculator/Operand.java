package calculator;

public class Operand {
    private int operand;

    public Operand(String element) {
        this.operand = Integer.parseInt(element);
    }

    public int getOperand() {
        return operand;
    }
}
