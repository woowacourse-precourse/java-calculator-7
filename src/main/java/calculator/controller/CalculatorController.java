package calculator.controller;

import calculator.controller.converter.Converter;
import calculator.controller.factory.ExpressionFactory;
import calculator.model.expression.Expression;
import calculator.model.operand.Operand;
import calculator.view.input.InputView;
import calculator.view.output.OutputView;

public class CalculatorController {  // 의존성을 외부에 드러냄

    private final InputView inputView;
    private final OutputView outputView;
    private final Converter<Expression, ? extends Operand> operandConverter;

    public CalculatorController(final InputView inputView, final OutputView outputView,
                                final Converter<Expression, ? extends Operand> operandConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.operandConverter = operandConverter;
    }

    public void calculate() {
        final String input = inputView.readInput();
        final Operand operand = preprocessInput(input);
        final int output = performCalculation(operand);
        outputView.displayOutput(output);
    }

    private Operand preprocessInput(final String input) {
        final Expression expression = ExpressionFactory.createExpression(input);
        return operandConverter.convert(expression);
    }

    private int performCalculation(final Operand operand) {
        return operand.sum();
    }
}
