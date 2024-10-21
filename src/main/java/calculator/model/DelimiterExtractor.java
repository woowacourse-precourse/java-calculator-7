package calculator.model;

public class DelimiterExtractor {
    public static final String DEFAULT_DELIMITER = ",|:";

    public static DelimiterExtractionResult extractDelimiterAndNumbers(String input) {
        String delimiter = DEFAULT_DELIMITER;
        String numbers = input;

        return new DelimiterExtractionResult(delimiter, numbers);
    }
}
