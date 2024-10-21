package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorValues {

    private final List<Integer> numbers = new ArrayList<>();

    private String delimiter;

    private String expression;

    public CalculatorValues() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void addNumbersFromInputByDelimiter(String token) {
        if(token.isEmpty()) {
            numbers.add(0);
            return;
        }
        numbers.add(Integer.parseInt(token));
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