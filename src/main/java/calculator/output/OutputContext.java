package calculator.output;

import calculator.output.strategy.OutputStrategy;

public class OutputContext {
    private OutputStrategy strategy;

    public OutputContext(OutputStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(OutputStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(String data) {
        strategy.output(data);
    }
}
