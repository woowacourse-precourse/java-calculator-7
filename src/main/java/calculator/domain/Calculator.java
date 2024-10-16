package calculator.domain;

public class Calculator {
    private static final String defaultSeparator = "[,;]";

    private Operands operands;

    public Calculator(String input) {
        System.out.println("입력된 문자열 : " + input);
        String[] splitInput = input.split(defaultSeparator);

        this.operands = new Operands(splitInput);
    }

    public int sum() {
        return operands.getOperands()
                .stream()
                .mapToInt(Operand::getOperand)
                .sum();
    }
}
