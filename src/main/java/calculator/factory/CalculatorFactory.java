package calculator.factory;

import calculator.calc.Calculator;
import calculator.splitter.NormalSplitter;

/**
 * Calculator Config
 */
public class CalculatorFactory {

    public Calculator calculator() {
        return new Calculator(normalSplliter());
    }

    private NormalSplitter normalSplliter() {
        return new NormalSplitter();
    }
}
