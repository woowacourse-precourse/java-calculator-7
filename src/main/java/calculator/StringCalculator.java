package calculator;

import calculator.calculateStrategy.CalculateStrategy;
import calculator.delimiterStrategy.DelimiterStrategy;
import java.util.List;

public class StringCalculator {
    private final String startCustomPattern;
    private final String endCustomPattern;
    private CalculateStrategy calculateStrategy;
    private DelimiterStrategy delimiterStrategy;
    private calculator.numberStrategy.NumberStrategy numberStrategy;
    private final String userInput;

    public StringCalculator(String userInput) {
        this.startCustomPattern = "//";
        this.endCustomPattern = "\n";
        this.userInput = userInput;
    }

    public String getStartCustomPattern() {
        return startCustomPattern;
    }

    public String getEndCustomPattern() {
        return endCustomPattern;
    }

    public void setCalculateStrategy(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    public void setDelimiterStrategy(DelimiterStrategy delimiterStrategy) {
        this.delimiterStrategy = delimiterStrategy;
    }

    public void setNumberStrategy(calculator.numberStrategy.NumberStrategy numberStrategy) {
        this.numberStrategy = numberStrategy;
    }

    public Integer operate() {
        List<String> results = delimiterStrategy.decideDelimiter(userInput);
        return calculateStrategy.add(
                numberStrategy.extractNumber(results.getFirst(), results.subList(1, results.size())));
    }

    public Integer emptyStringOperate() {
        return calculateStrategy.add(List.of(0));
    }
}
