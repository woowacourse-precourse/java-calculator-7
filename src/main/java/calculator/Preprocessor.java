package calculator;

import java.util.List;

public class Preprocessor {
    private final DelimiterExtractor delimiterExtractor;

    public Preprocessor() {
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public List<Integer> preprocess(String input) {
        return new StringToNumberConverter().convert(delimiterExtractor.extractNumbers(input));
    }
}
