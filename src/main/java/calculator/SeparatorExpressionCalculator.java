package calculator;

public class SeparatorExpressionCalculator {
    private final OperatorMap operatorMap = OperatorMap.getInstance();

    public void operate() {
        String input = getInputFromConsole();
        boolean hasCustomSeparator = CustomSeparatorManager.hasCustomSeparator(input);
        if(hasCustomSeparator) {
            Separator customSeparator = CustomSeparatorManager.getCustomSeparator(input);
            operatorMap.registerSeparatorToOperand(customSeparator, OperatorEnum.PLUS);
        }
    }

    private String getInputFromConsole() {
        return CalculatorInputConsole.readLine();
    }
}
