package calculator.model;

import java.util.List;

public class Calculator {
    private final List<Term> terms;

    public Calculator(Expression expression) {
        this.terms = expression.getTerms();
    }

    public Integer addCalculate() {
        return terms.stream().mapToInt(Term::getValue).sum();
    }

    public Integer subtractCalculate() {
        return terms.stream().mapToInt(Term::getValue).reduce((a, b) -> a - b)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer multiplyCalculate() {
        return terms.stream().mapToInt(Term::getValue).reduce(1, (a, b) -> a * b);
    }
}
