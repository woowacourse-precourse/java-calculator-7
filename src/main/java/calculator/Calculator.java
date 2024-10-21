package calculator;

public class Calculator {
    public int sum(String input) {
        DelimiterExtractor extractor = new DelimiterExtractor(input);
        String delimiter = extractor.getDelimiter();
        String numbers = extractor.getNumbers();

        return NumberParser.parseAndSum(numbers, delimiter);
    }
}