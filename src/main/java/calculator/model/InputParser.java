package calculator.model;

public class InputParser {

    private final DelimiterExtractor extractor;

    public InputParser() {
        this.extractor = new DelimiterExtractor();
    }

    public String[] parseInput(String input) {
        if (input.isEmpty()) {
            return new String[]{};
        }
        if (input.startsWith("//")) {
            extractor.addCustomDelimiter(input);
            return input.substring(extractor.getContentStartIndex()).split(extractor.getDelimiter());
        }
        return input.split(extractor.getDelimiter());
    }
}
