package calculator;

import calculator.arithmeticUnit.PlusOperation;
import calculator.expression.Expression;
import calculator.expression.ExpressionExecutor;
import calculator.io.Display;
import calculator.io.InputReceiver;
import calculator.lexicalParser.CustomSeparatorParser;
import calculator.lexicalParser.ExpressionParser;
import calculator.operator.*;

import java.util.List;

public class SeparatorExpressionCalculator {
    private static final Separator COMMA_SEPARATOR = Separator.of(",");
    private static final Separator COLON_SEPARATOR = Separator.of(":");
    private static final Operator COMMA_OPERATOR = new Operator(COMMA_SEPARATOR, PlusOperation.getInstance());
    private static final Operator COLON_OPERATOR = new Operator(COLON_SEPARATOR, PlusOperation.getInstance());
    private final OperatorContainer operatorContainer;
    private final Display display;
    private final InputReceiver inputReceiver;

    public SeparatorExpressionCalculator(InputReceiver inputReceiver, Display display) {
        this.display = display;
        this.inputReceiver = inputReceiver;
        this.operatorContainer = generateDefaultContainer();
    }

    public OperatorContainer generateDefaultContainer() {
        return new OperatorContainer(List.of(COMMA_OPERATOR, COLON_OPERATOR));
    }

    public void operate() {
        display.showInputMessage();
        String input = inputReceiver.readInput();
        Expression expression = parseToExpression(input);
        ExpressionExecutor expressionExecutor = new ExpressionExecutor(operatorContainer);
        Operand result = expressionExecutor.calculate(expression);
        display.showResult(result.getValue());
    }

    private Expression parseToExpression(String input) {
        CustomSeparatorParser customSeparatorParser = CustomSeparatorParser.getInstance();
        registerIfHasCustomSeparator(input, customSeparatorParser);
        String removeCustomSeparatorDeclaration = customSeparatorParser.removeCustomSeparatorDeclaration(input);
        ExpressionParser expressionParser = new ExpressionParser(operatorContainer);
        return expressionParser.parse(removeCustomSeparatorDeclaration);
    }

    private void registerIfHasCustomSeparator(String input, CustomSeparatorParser customSeparatorParser) {
        if(customSeparatorParser.canParse(input)) {
            Separator separator = customSeparatorParser.parse(input);
            operatorContainer.add(new Operator(separator, PlusOperation.getInstance()));
        }
    }
}
