package calculator.model;

import calculator.utils.IntegerExtractor;
import calculator.utils.SumExpression;

public class CalculatorImpl implements Calculator{

    private final CalculatorValues calculatorValues;

    public CalculatorImpl() {
        this.calculatorValues = new CalculatorValues();
    }

    @Override
    public void insertValues(String input) {

        boolean hasCustomDelimiter = input.startsWith("//");

        String expression = hasCustomDelimiter ? input.substring(5) : input;
        String delimiter = hasCustomDelimiter ? String.valueOf(input.charAt(2)) : "[,:]";

        calculatorValues.setExpression(expression);
        calculatorValues.setDelimiter(delimiter);
    }

    @Override
    public void extract() {
        IntegerExtractor.extractIntegerFromExpression(calculatorValues);
    }

    @Override
    public int sum() {
        return SumExpression.sum(calculatorValues);
    }
}