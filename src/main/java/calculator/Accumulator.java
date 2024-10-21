package calculator;

import calculator.splitter.DelegateDelimiterSplitter;
import java.util.List;

public class Accumulator {

    private final DelegateDelimiterSplitter splitter;

    public Accumulator(DelegateDelimiterSplitter splitter) {
        this.splitter = splitter;
    }

    public int sum(String input) {
        Positives positives = toNumbers(split(input));
        Positive result = positives.sum();

        return result.value();
    }

    private Positives toNumbers(List<String> value) {
        return Positives.from(value);
    }

    private List<String> split(String input) {
        return splitter.split(input);
    }
}
