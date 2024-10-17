package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Terms {
    private final List<Term> terms = new ArrayList<>();

    public Terms(String expression, Separator separator) {
        extractTerms(expression, separator);
    }

    private void extractTerms(String expression, Separator separator) {
        for (String part : expression.split("[" + separator.getSeparator() + "]")) {
            terms.add(new Term(part.isEmpty() ? "0" : part));
        }
    }

    public List<Term> getTerms() {
        return terms;
    }
}
