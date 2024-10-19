package calculator.model.expression;

import java.util.Collections;
import java.util.List;

public final class DefaultExpression implements Expression {

    public static final String DEFAULT_DELIMITER = "[,:]";

    private final String input;
    private final String delimiter;
    private final List<String> operands;

    public DefaultExpression(final String input) {
        validateNotNull(input);
        this.input = input;
        this.delimiter = DEFAULT_DELIMITER;
        this.operands = extractOperands(input);
    }

    private void validateNotNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null일 수 없습니다.");
        }
    }

    private List<String> extractOperands(final String input) {
        if (input.isBlank()) {
            return Collections.singletonList("0");
        }
        return List.of(input.split(delimiter));
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
