package calculator;

import calculator.calculateStrategy.CalculateStrategy;
import calculator.delimiterStrategy.DelimiterStrategy;
import calculator.numberStrategy.NumberStrategy;
import java.util.List;

public class StringCalculator {
    private final static String startCustomPattern = "//";
    private final static String endCustomPattern = "\n";
    private final DelimiterStrategy delimiterStrategy;
    private final NumberStrategy numberStrategy;
    private final CalculateStrategy calculateStrategy;
    private final String userInput;

    public StringCalculator(String userInput, DelimiterStrategy delimiterStrategy, NumberStrategy numberStrategy,
                            CalculateStrategy calculateStrategy) {
        this.userInput = userInput;
        this.delimiterStrategy = delimiterStrategy;
        this.numberStrategy = numberStrategy;
        this.calculateStrategy = calculateStrategy;
    }

    public static String getStartCustomPattern() {
        return startCustomPattern;
    }

    public static String getEndCustomPattern() {
        return endCustomPattern;
    }

    public Integer operate() {
        List<String> results = delimiterStrategy.setUpDelimiter(userInput);
        return calculateStrategy.add(
                numberStrategy.extractNumber(results.getFirst(), results.subList(1, results.size())));
    }

    public Integer emptyStringOperate() {
        return calculateStrategy.add(List.of(0));
    }
}
