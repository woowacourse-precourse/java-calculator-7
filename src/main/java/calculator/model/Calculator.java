package calculator.model;

import java.util.List;

public class Calculator {
    private final Expression expression;
    private final String operation;

    public Calculator(Expression expression, String operation) {
        this.expression = expression;
        this.operation = operation;
    }

    public Integer calculate() {
        List<Term> terms = expression.getTerms();

        switch (operation) {
            case "add":
                return addCalculate(terms);
            case "subtract":
                return subtractCalculate(terms);
            case "multiply":
                return multiplyCalculate(terms);
            default:
                throw new IllegalArgumentException("잘못된 operation입니다.");
        }
    }

    private Integer addCalculate(List<Term> terms) {
        return terms.stream().mapToInt(Term::getValue).sum();
    }

    private Integer subtractCalculate(List<Term> terms) {
        return terms.stream().mapToInt(Term::getValue).reduce((a, b) -> a - b)
                .orElseThrow(() -> new IllegalArgumentException("표현식이 비어 있습니다."));
    }

    private Integer multiplyCalculate(List<Term> terms) {
        return terms.stream().mapToInt(Term::getValue).reduce(1, (a, b) -> a * b);
    }
}
