package calculator.model;

import calculator.utils.SumExpression;
import calculator.utils.extractor.NumberExtractor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculatorValues {

    private final List<BigDecimal> numbers = new ArrayList<>();

    private final String delimiter;

    private final String expression;

    public CalculatorValues(String delimiter, String expression) {
        this.delimiter = delimiter;
        this.expression = expression;
    }

    public List<BigDecimal> getNumbers() {
        return numbers;
    }

    public void addNumbersFromInputByDelimiter(String token) {
        if(token.isEmpty()) {
            numbers.add(BigDecimal.valueOf(0));
            return;
        }
        numbers.add(new BigDecimal(token));
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getExpression() {
        return expression;
    }

    public BigDecimal sum() {
        return SumExpression.sum(this);
    }

    public void extract() {
        NumberExtractor.extractIntegerFromExpression(this);
    }
}