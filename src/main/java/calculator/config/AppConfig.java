package calculator.config;

import calculator.domain.Adder;
import calculator.domain.Calculator;
import calculator.domain.PositiveAdder;

public class AppConfig {

    public Calculator calculator() {
        return new Calculator(adder());
    }

    public Adder adder() {
        return new PositiveAdder();
    }
}
