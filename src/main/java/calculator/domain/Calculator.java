package calculator.domain;

public class Calculator {
    private static final String defaultSeparator = "[,:]";
    private String customSeparator = "";

    private Operands operands;

    public Calculator(String inputValue) {
        setCustomSeparator(inputValue);

        String calcValue = getCalcValue(inputValue);
        String[] splitInput = splitBySeparator(calcValue);

        this.operands = new Operands(splitInput);
    }

    private void setCustomSeparator(String inputValue) {
        if (inputValue.startsWith("//")) {
            this.customSeparator = String.valueOf(inputValue.charAt(2));
        }
    }

    private String getCalcValue(String inputValue) {
        if (inputValue.startsWith("//")) {
            return inputValue.substring(5);
        }
        return inputValue;
    }

    private String[] splitBySeparator(String inputValue) {
        if (customSeparator.isEmpty()) {
            return inputValue.split(defaultSeparator);
        }
        return inputValue.split(customSeparator);
    }

    public int sum() {
        return operands.getOperands()
                .stream()
                .mapToInt(Operand::getOperand)
                .sum();
    }
}
