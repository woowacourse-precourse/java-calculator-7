package calculator.model;

import static calculator.constants.Symbol.END_BRACKET;
import static calculator.constants.Symbol.START_BRACKET;

import java.util.ArrayList;
import java.util.List;

public class Terms {
    private final String ZERO = "0";
    private final List<Term> terms = new ArrayList<>();

    public Terms(String expression, Separator separator) {
        extractTerms(expression, separator);
    }

    private void extractTerms(String expression, Separator separator) {
        for (String part : expression.split(START_BRACKET + separator.getSeparator() + END_BRACKET)) {
            terms.add(new Term(part.isEmpty() ? ZERO : part));
        }
    }

    public List<Term> getTerms() {
        return terms;
    }
}
