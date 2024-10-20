package calculator;

public class NumberExtractor {
    private final DelimiterExtractor delimiterExtractor;
    private final String inputString;

    public NumberExtractor(String inputString) {
        this.inputString = inputString;
        this.delimiterExtractor = new DelimiterExtractor(inputString);
    }

    public String[] extractDelimitedNumbers() {
        if (delimiterExtractor.hasCustomDelimiter()) {
            String customInputString = inputString.substring(inputString.indexOf("\\n") + 2);
            return customInputString.split(delimiterExtractor.getDelimiter());
        }
        return inputString.split(delimiterExtractor.getDelimiter());
    }
}
