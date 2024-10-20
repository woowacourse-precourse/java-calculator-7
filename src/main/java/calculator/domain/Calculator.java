package calculator.domain;

import java.util.List;
import java.util.Set;

public class Calculator {

    private final DelimiterExtractor delimiterExtractor;
    private final NumberSplitter numberSplitter;

    public Calculator() {
        this.delimiterExtractor = new DelimiterExtractor();
        this.numberSplitter = new NumberSplitter();
    }

    public int calculate(Input input) {
        Set<Character> delimiters = delimiterExtractor.extractDelimiters(input.getDelimiterPart());
        List<String> invalidNumbers = numberSplitter.split(input.getNumberPart(), delimiters);

        PositiveNumbers numbers = new PositiveNumbers(invalidNumbers);
        return numbers.calculateSum();
    }
}
