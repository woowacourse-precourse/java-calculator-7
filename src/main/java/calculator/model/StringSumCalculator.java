package calculator.model;

public class StringSumCalculator implements Calculator {

    private final DelimiterManager delimiterManager;
    private final StringParser stringParser;

    public StringSumCalculator(DelimiterManager delimiterManager, StringParser stringParser) {
        this.delimiterManager = delimiterManager;
        this.stringParser = stringParser;
    }

    @Override
    public int calculate(String value) {
        delimiterManager.registerCustomDelimiters(value);

        return 0;
    }
}
