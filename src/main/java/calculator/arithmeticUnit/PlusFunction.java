package calculator.arithmeticUnit;

public class PlusFunction extends ArithmeticFunction {
    private static final PlusFunction INSTANCE = new PlusFunction();

    private PlusFunction() {
        super((leftOperand, rightOperand) -> leftOperand + rightOperand);
    }

    public static PlusFunction getInstance() {
        return INSTANCE;
    }
}
