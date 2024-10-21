package calculator.component;

import calculator.util.Validator;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private final Delimiter delimiter;
    private final String formula;

    Parser(String expression) {
        this.delimiter = Delimiter.of(expression);
        this.formula = extractFormula(expression);
    }

    public List<Integer> parse() {
        return Arrays.stream(formula.split(delimiter.toString()))
                .map(Validator::checkNumeric)
                .map(Integer::parseInt)
                .map(Validator::checkPositive)
                .toList();
    }

    private String extractFormula(String expression) {
        if (!Validator.checkEndsWithNumber(expression)) {
            throw new IllegalArgumentException();
        }

        if (checkCustomDelimiter(expression)) {
            return expression.substring(5);
        }

        return expression;
    }

    private boolean checkCustomDelimiter(String expression) {
        // TODO: CHECK IF THE EXPRESSION IS A VALID CUSTOM DELIMITER
        return expression.startsWith("//");
    }
}
