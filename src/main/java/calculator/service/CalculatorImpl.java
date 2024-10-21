package calculator.service;

import calculator.model.CalculatorValues;
import calculator.utils.extractor.DelimiterExtractor;
import calculator.utils.extractor.ExpressionExtractor;

import java.math.BigDecimal;

public class CalculatorImpl implements Calculator {

    private CalculatorValues calculatorValues;

    public CalculatorImpl() {
    }

    @Override
    public void initValues(String input) {
        boolean hasCustomDelimiter = input.startsWith("//");
        String expression = ExpressionExtractor.extractExpression(
                input,
                hasCustomDelimiter
        );
        String delimiter = DelimiterExtractor.extractDelimiter(
                input,
                hasCustomDelimiter
        );
        this.calculatorValues = new CalculatorValues(delimiter, expression);
    }

    @Override
    public BigDecimal execute() {
        calculatorValues.extract();
        return calculatorValues.sum();
    }

}