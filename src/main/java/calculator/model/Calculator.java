package calculator.model;

import java.util.List;

public class Calculator {
    private final String ADDITION = "add";
    private final String SUBTRACT = "subtract";
    private final String MULTIPLY = "multiply";
    private final Expression expression;
    private final String operation;

    public Calculator(Expression expression, String operation) {
        this.expression = expression;
        this.operation = operation;
    }

    public Integer calculate() {
        List<Term> terms = expression.getTerms();

        switch (operation) {
            case ADDITION:
                return addCalculate(terms);
            case SUBTRACT:
                return subtractCalculate(terms);
            case MULTIPLY:
                return multiplyCalculate(terms);
            default:
                throw new IllegalArgumentException();

        }
    }

    private Integer addCalculate(List<Term> terms) {
        return terms.stream().mapToInt(Term::getValue).sum();
    }

    private Integer subtractCalculate(List<Term> terms) {
        return terms.stream().mapToInt(Term::getValue).reduce((a, b) -> a - b)
                .orElseThrow(IllegalArgumentException::new);
    }

    private Integer multiplyCalculate(List<Term> terms) {
        return terms.stream().mapToInt(Term::getValue).reduce(1, (a, b) -> a * b);
    }
}
