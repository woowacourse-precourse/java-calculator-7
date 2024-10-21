package calculator.core;

import calculator.model.LongCalculatorModel;
import calculator.operation.AdditionalLongCalculatorOperation;
import calculator.operation.LongCalculatorOperation;
import calculator.parser.BasicLongMathematicalExpressionParser;
import calculator.parser.BasicSeparatorParser;
import calculator.parser.LongMathematicalExpressionParser;
import calculator.parser.SeparatorParser;
import calculator.splitter.ExpressionSplitter;
import calculator.view.AdditionCalculatorView;
import calculator.view.CalculatorView;
import java.util.Set;

public class LongCalculator implements Calculator {
    private final SeparatorParser separatorParser;
    private final LongMathematicalExpressionParser mathematicalExpressionParser;
    private final CalculatorView calculatorView;
    private final LongCalculatorOperation longCalculatorOperation;
    private final ExpressionSplitter expressionSplitter;
    private final Set defaultSeparators;

    public LongCalculator() {
        this(new BasicSeparatorParser(), new BasicLongMathematicalExpressionParser(),
                new AdditionCalculatorView(), new AdditionalLongCalculatorOperation());
    }

    public LongCalculator(
            SeparatorParser separatorParser,
            LongMathematicalExpressionParser mathematicalExpressionParser,
            CalculatorView calculatorView,
            LongCalculatorOperation longCalculatorOperation
    ) {
        this.separatorParser = separatorParser;
        this.mathematicalExpressionParser = mathematicalExpressionParser;
        this.calculatorView = calculatorView;
        this.longCalculatorOperation = longCalculatorOperation;
        this.expressionSplitter = new ExpressionSplitter(
                separatorParser.getVALID_CUSTOM_SEPARATOR_PATTERN(),
                mathematicalExpressionParser.getVALID_MATHEMATICAL_EXPRESSION_PATTERN());
        this.defaultSeparators = separatorParser.getSeparators();
    }

    private void calculate(LongCalculatorModel model) {
        expressionSplitter.splitExpression(model);
        separatorParser.parse(model);
        mathematicalExpressionParser.parse(model);
        longCalculatorOperation.operate(model);
    }

    @Override
    public void startCalculation() {
        String input = calculatorView.input();
        LongCalculatorModel model = new LongCalculatorModel(input, defaultSeparators);

        if (!input.equals("")) {
            expressionSplitter.isValid(model);
            calculate(model);
        }

        model.generateResult();
        calculatorView.output(model);
    }

}
