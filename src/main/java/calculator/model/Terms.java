package calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Terms {
    private final List<Term> terms;

    public Terms(String expression, Separator separator) {
        this.terms = parseTerms(expression, separator);
    }

    private List<Term> parseTerms(String expression, Separator separator) {
        String[] parts = expression.split(separator.getSeparator());
        return Arrays.stream(parts)
                .map(Term::new)
                .collect(Collectors.toList());
    }

    public Integer addition() {
        return terms.stream()
                .mapToInt(Term::getValue)
                .sum();
    }

    public Integer subtract() {
        return terms.stream().mapToInt(Term::getValue).reduce((a, b) -> a - b)
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer multiply() {
        return terms.stream()
                .mapToInt(Term::getValue)
                .reduce(1, (a, b) -> a * b);
    }
}
