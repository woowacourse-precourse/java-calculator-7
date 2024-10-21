package calculator;

public class StringCalculator {
    private final StringExtractor extractor;
    private final NumberParser parser;

    public StringCalculator(StringExtractor extractor, NumberParser parser) {
        this.extractor = extractor;
        this.parser = parser;
    }

    public int sum(String input) throws IllegalArgumentException {
        String[] tokens = extractor.extract(input);
        int sum = 0;
        for (String token: tokens) {
            sum += parser.parsePositiveInt(token);
        }
        return sum;
    }
}
