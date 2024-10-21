package calculator;

public class StringCalculator {
    private final DelimiterParser delimiterParser = new DelimiterParser();

    private String[] makeStringToExpression(String input) {
        DelimiterContentPair parsed = delimiterParser.parseInput(input);
        return makeStrArray(parsed);
    }

    private String[] makeStrArray(DelimiterContentPair parsedInput) {
        String delimiter = parsedInput.getDelimiter();
        String content = parsedInput.getContent();
        return content.split(delimiter);
    }
}