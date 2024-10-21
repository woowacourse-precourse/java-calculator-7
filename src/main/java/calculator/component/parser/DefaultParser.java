package calculator.component.parser;

import calculator.util.Validator;
import java.util.Arrays;
import java.util.List;

public class DefaultParser implements Parser {
    private static final String DELIMITERS = "[,:]";

    private final String formula;

    DefaultParser(String expression) {
        this.formula = expression;
    }

    @Override
    public List<Integer> parse() {
        if (formula.isBlank()) {
            return List.of(0);
        }

        return Arrays.stream(formula.split(DELIMITERS))
                .map(Validator::checkNumeric)
                .map(Integer::parseInt)
                .map(Validator::checkPositive)
                .toList();
    }
}
