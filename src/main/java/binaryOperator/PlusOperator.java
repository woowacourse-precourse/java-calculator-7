package binaryOperator;

public class PlusOperator implements BinaryOperator {
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}
