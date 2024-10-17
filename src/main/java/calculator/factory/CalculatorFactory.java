package calculator.factory;

import calculator.calc.Calculator;
import calculator.splitter.NormalSplitter;

/**
 * Calculator Config
 */
public class CalculatorFactory {

    public Calculator calculator() {
        return new Calculator(normalSplitter());
    }

    private NormalSplitter normalSplitter() {
        return new NormalSplitter();
    }
}
