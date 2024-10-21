package calculator;

import calculator.splitter.DelegateDelimiterSplitter;
import java.util.List;

public class Accumulator {

    private final DelegateDelimiterSplitter splitter;

    public Accumulator(DelegateDelimiterSplitter splitter) {
        this.splitter = splitter;
    }

    public int sum(String input) {
        Numbers numbers = toNumbers(split(input));
        Number result = numbers.sum();

        return result.value();
    }

    private Numbers toNumbers(List<String> value) {
        return Numbers.from(value);
    }

    private List<String> split(String input) {
        return splitter.split(input);
    }
}
