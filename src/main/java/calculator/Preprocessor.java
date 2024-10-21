package calculator;

import java.util.List;

public class Preprocessor {
    private final DelimiterExtractor delimiterExtractor;
    private final FormatValidator formatValidator;

    public Preprocessor(DelimiterExtractor delimiterExtractor, FormatValidator formatValidator) {
        this.delimiterExtractor = delimiterExtractor;
        this.formatValidator = formatValidator;
    }

    public List<Integer> preprocess(String input) {
        input = delimiterExtractor.extractDelimiter(input);
        formatValidator.validateInput(input, delimiterExtractor.getDelimiter());
        return new StringToNumberConverter(List.of(input.split(delimiterExtractor.getDelimiter()))).convert();
    }
}
