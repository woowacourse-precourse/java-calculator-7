package calculator;

import calculator.calculateStrategy.Calculate;
import calculator.delimiterStrategy.DelimiterStrategy;

public class StringCalculator {
    private Calculate calculate;
    private DelimiterStrategy delimiterStrategy;
    private calculator.NumberStrategy.NumberStrategy numberStrategy;
    private final String userInput;

    public StringCalculator(String userInput) {
        this.userInput = userInput;
    }

    public void setCalculate(Calculate calculate) {
        this.calculate = calculate;
    }

    public void setDelimiterStrategy(DelimiterStrategy delimiterStrategy) {
        this.delimiterStrategy = delimiterStrategy;
    }

    public void setNumberStrategy(calculator.NumberStrategy.NumberStrategy numberStrategy) {
        this.numberStrategy = numberStrategy;
    }

    public Integer operate() {
        return calculate.add(
                numberStrategy.extractNumber(userInput,
                        delimiterStrategy.decideDelimiter(userInput)));
    }
}
