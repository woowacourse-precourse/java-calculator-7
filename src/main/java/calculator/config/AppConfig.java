package calculator.config;

import calculator.controller.CalculatorController;
import calculator.domain.*;
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

    public NumberExtractor numberStringExtractor() {
        return new NumberExtractor(stringTokenizer());
    }

    public StringSplitter stringTokenizer() {
        return new StringSplitter(delimiterHandler());
    }

    public DelimiterHandler delimiterHandler() {
        return new DelimiterHandler(new CustomDelimiterExtractor());
    }
}
