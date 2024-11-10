package calculator.controller.converter.mock;

import calculator.model.expression.Expression;
import java.util.List;

public class MockExpression implements Expression {

    private final String input;
    private final String delimiter;
    private final List<String> operands;

    public MockExpression(final String input, final String delimiter, final List<String> operands) {
        this.input = input;
        this.delimiter = delimiter;
        this.operands = operands;
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

    @Override
    public List<String> getOperands() {
        return operands;
    }
}
