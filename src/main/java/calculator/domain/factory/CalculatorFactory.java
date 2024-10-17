package calculator.domain.factory;

import calculator.domain.calc.Calculator;
import calculator.domain.splitter.NormalSplitter;
import calculator.domain.splitter.RegexSplitter;

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

    private RegexSplitter regexSplitter() {
        return new RegexSplitter();
    }
}