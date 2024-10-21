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
        if (formula.isBlank()) {
            return List.of(0);
        }

        if (!Validator.checkEndsWithNumber(formula)) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(formula.split(delimiter.toString()))
                .map(Validator::checkNumeric)
                .map(Integer::parseInt)
                .map(Validator::checkPositive)
                .toList();
    }

    private String extractFormula(String expression) {
        String formula = expression;
        if (checkCustomDelimiter(formula)) {
            formula = expression.substring(5);
        }

        return formula;
    }

    private boolean checkCustomDelimiter(String expression) {
        if (expression.contains("//")) {
            if (Validator.checkValidCustomDelimiter(expression)) {
                return true;
            } else {
                throw new IllegalArgumentException();
            }
        }
        return false;
    }
}
