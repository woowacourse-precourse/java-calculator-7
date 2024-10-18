package calculator.config;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.CustomDelimiterExtractor;
import calculator.domain.NumberStringExtractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(
                new InputView(),
                new OutputView(),
                calculator());
    }

    public Calculator calculator() {
        return new Calculator(numberStringExtractor());
    }

    public NumberStringExtractor numberStringExtractor() {
        return new NumberStringExtractor(new CustomDelimiterExtractor());
    }
}
