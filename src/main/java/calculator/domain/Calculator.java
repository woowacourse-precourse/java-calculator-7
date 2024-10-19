package calculator.domain;

public class Calculator {
    private Separator separator;
    private Operands operands;

    public Calculator(String inputValue) {
        Separator separator = new Separator(inputValue);
        String[] splitInput = separator.splitBySeparator(inputValue);
        this.operands = new Operands(splitInput);
    }

    public int sum() {
        return operands.getOperands()
                .stream()
                .mapToInt(Operand::getOperand)
                .sum();
    }
}
