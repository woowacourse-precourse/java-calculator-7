package calculator;

import java.util.List;

public class Preprocessor {
    private final Extractor extractor;

    public Preprocessor() {
        this.extractor = new Extractor();
    }

    public List<Integer> preprocess(String input) {
        return new StringToNumberConverter().convert(extractor.extractNumbers(input));
    }
}
