package calculator.parser;

public class InputParser {

    DelimiterExtractor extractor = new DelimiterExtractor();

    private static final int BEGIN_INDEX = 5;

    public String[] parseInput(String input) {
        if (input.isEmpty()) {
            return new String[]{};
        }
        if (input.startsWith("//")) {
            return input.substring(BEGIN_INDEX).split(extractor.extractCustomDelimiter(input));
        }
        return input.split(extractor.getDefaultDelimiter());
    }
}
