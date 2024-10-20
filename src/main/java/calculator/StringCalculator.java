package calculator;

import calculator.calculateStrategy.CalculateStrategy;
import calculator.delimiterStrategy.DelimiterStrategy;

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
        return calculate.add(
                numberStrategy.extractNumber(userInput,
                        delimiterStrategy.decideDelimiter(userInput)));
    }
}
