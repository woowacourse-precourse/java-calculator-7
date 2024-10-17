package calculator.domain.factory;

import calculator.domain.calc.Calculator;
import calculator.domain.splitter.NormalSplitter;

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
