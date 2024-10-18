package calculator.arithmeticUnit;

public class PlusOperation extends ArithmeticOperation {
    private static final PlusOperation INSTANCE = new PlusOperation();

    private PlusOperation() {
        super((leftOperand, rightOperand) -> leftOperand + rightOperand);
    }

    public static PlusOperation getInstance() {
        return INSTANCE;
    }
}
