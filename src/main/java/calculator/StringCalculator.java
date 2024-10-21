package calculator;

public class StringCalculator {
    private final DelimiterExtractor delimiterExtractor;

    public StringCalculator() {
        this.delimiterExtractor = new DelimiterExtractor();
    }

    public int calculate(String numbers) {
        if (numbers.isEmpty()) return 0;
        return delimiterExtractor.getResult(numbers);
    }
}