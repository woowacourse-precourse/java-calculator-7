package calculator.input;

import calculator.input.strategy.InputStrategy;

public class InputContext {
    private InputStrategy strategy;

    public InputContext(InputStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(InputStrategy strategy) {
        this.strategy = strategy;
    }

    public String execute() {
        return strategy.input();
    }
}
