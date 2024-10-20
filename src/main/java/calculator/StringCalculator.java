package calculator;

import calculator.calculateStrategy.CalculateStrategy;
import calculator.delimiterStrategy.DelimiterStrategy;
import java.util.List;

public class StringCalculator {
    private CalculateStrategy calculate;
    private DelimiterStrategy delimiterStrategy;
    private calculator.numberStrategy.NumberStrategy numberStrategy;
    private final String userInput;

    public StringCalculator(String userInput) {
        this.userInput = userInput;
    }

    public void setCalculate(CalculateStrategy calculate) {
        this.calculate = calculate;
    }

    public void setDelimiterStrategy(DelimiterStrategy delimiterStrategy) {
        this.delimiterStrategy = delimiterStrategy;
    }

    public void setNumberStrategy(calculator.numberStrategy.NumberStrategy numberStrategy) {
        this.numberStrategy = numberStrategy;
    }

    public Integer operate() {
        List<String> results = delimiterStrategy.decideDelimiter(userInput);
        return calculate.add(
                numberStrategy.extractNumber(results.get(0), results.subList(1, results.size())));
    }

    public Integer emptyStringOperate() {
        return calculate.add(List.of(0));
    }
}
