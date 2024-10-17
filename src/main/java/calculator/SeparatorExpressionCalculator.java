package calculator;

import java.util.Set;

public class SeparatorExpressionCalculator {
    private static final Separator COMMA_SEPARATOR = new Separator(",");
    private static final Separator COLON_SEPARATOR = new Separator(":");
    private final OperatorMap operatorMap = OperatorMap.getInstance();
    private final Separators separators;

    public SeparatorExpressionCalculator() {
        this.separators = new Separators(Set.of(COMMA_SEPARATOR, COLON_SEPARATOR));
    }

    public void operate() {
        String input = getInputFromConsole();
        Expression expression = parseToExpression(input);
    }

    private Expression parseToExpression(String input) {
        registerCustomSeparators(input);
        ExpressionValidator validator = new ExpressionValidator(separators);
        ExpressionParser parser = new ExpressionParser(validator, separators);
        return parser.parse(input);
    }

    private void registerCustomSeparators(String input) {
        CustomSeparatorManager manager = new CustomSeparatorManager(input);
        boolean hasCustomSeparator = manager.hasCustomSeparator();
        if (hasCustomSeparator) {
            Separator customSeparator = manager.getCustomSeparator();
            separators.add(customSeparator);
            operatorMap.registerSeparatorToOperator(customSeparator, OperatorEnum.PLUS);
        }
    }

    private String getInputFromConsole() {
        return CalculatorInputConsole.readLine();
    }
}
