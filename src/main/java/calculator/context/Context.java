package calculator.context;

import calculator.strategy.CustomDelimiterExtractionStrategy;
import calculator.strategy.DefaultExtractionStrategy;
import calculator.strategy.ExtractionStrategy;

public class Context {

    private ExtractionStrategy strategy;
    private final Calculation calculation;

    public Context() {
        calculation = new Calculation();
    }

    public void setStrategy(String problem) {
        if (problem.startsWith("//")) {
            this.strategy = new CustomDelimiterExtractionStrategy();
        } else {
            this.strategy = new DefaultExtractionStrategy();
        }
    }

    public int problemCalculate(String problem) {
        return calculation.calculate(strategy.extract(problem));
    }
}
