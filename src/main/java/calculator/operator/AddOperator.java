package calculator.operator;

public class AddOperator implements Operator {

    private AddOperator() {}

    private static class InstanceHolder {
        private static final AddOperator INSTANCE = new AddOperator();
    }

    public static AddOperator getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public int compute(int a, int b) {
        return a + b;
    }
}
