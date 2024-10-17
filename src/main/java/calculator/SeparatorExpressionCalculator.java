package calculator;

public class SeparatorExpressionCalculator {
    private final OperatorMap operatorMap = OperatorMap.getInstance();

    public void operate() {
        String input = getInputFromConsole();
        CustomSeparatorManager manager = new CustomSeparatorManager(input);
        boolean hasCustomSeparator = manager.hasCustomSeparator();
        if(hasCustomSeparator) {
            Separator customSeparator = manager.getCustomSeparator();
            operatorMap.registerSeparatorToOperator(customSeparator, OperatorEnum.PLUS);
        }
    }

    private String getInputFromConsole() {
        return CalculatorInputConsole.readLine();
    }
}
