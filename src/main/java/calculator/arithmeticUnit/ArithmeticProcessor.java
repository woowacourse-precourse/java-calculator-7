package calculator.arithmeticUnit;

public class ArithmeticProcessor {
    private ArithmeticProcessor() {
    }

    public static int operate(ArithmeticFunction arithmeticFunction, int leftOperand, int rightOperand) {
        return arithmeticFunction.getFunction().apply(leftOperand, rightOperand);
    }
}
