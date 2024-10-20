package calculator;

public class Calculator {
    private final Extractor extractor;
    private final Parser parser;

    public Calculator() {
        this.extractor = new Extractor();
        this.parser = new Parser();
    }

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        if(input.startsWith("//")) {
            String customDelimiter = extractor.extractCustomDelimiter(input);
            input = extractor.extractSentence(input);
            parser.updateDelimiter(customDelimiter);
        }

        return parser.calculateSentence(input);
    }
}

