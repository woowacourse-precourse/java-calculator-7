package calculator.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculatorValues {

    private final List<BigDecimal> numbers = new ArrayList<>();

    private String delimiter;

    private String expression;

    public CalculatorValues() {
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

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}