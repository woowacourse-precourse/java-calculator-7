package calculator.model;

import calculator.utils.SumExpression;
import calculator.utils.extractor.DelimiterExtractor;
import calculator.utils.extractor.ExpressionExtractor;
import calculator.utils.extractor.NumberExtractor;

import java.math.BigDecimal;

public class CalculatorImpl implements Calculator{

    private CalculatorValues calculatorValues;

    public CalculatorImpl() {
    }

    @Override
    public void insertValues(String input) {

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
    public void extract() {
        NumberExtractor.extractIntegerFromExpression(calculatorValues);
    }

    @Override
    public BigDecimal sum() {
        return SumExpression.sum(calculatorValues);
    }
}