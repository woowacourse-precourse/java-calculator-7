package calculator.parser;

public class InputParser {

    DelimiterExtractor extractor = new DelimiterExtractor();

    public String[] parseInput(String input) {
        if (input.isEmpty()) {
            return new String[]{};
        }
        if (input.startsWith("//")) {
            return input.split(extractor.extractCustomDelimiter(input));
        }
        return input.split(extractor.getDefaultDelimiter());
    }
}
