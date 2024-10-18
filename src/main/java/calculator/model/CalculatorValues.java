package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorNumber {

    private final List<Integer> numbers = new ArrayList<>();

    private final String delimiter;

    private final String expression;

    public CalculatorNumber(String expression, String delimiter) {
        this.expression = expression;
        this.delimiter = delimiter;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void addNumbersFromInputByDelimiter(int num) {
        numbers.add(num);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getExpression() {
        return expression;
    }
}