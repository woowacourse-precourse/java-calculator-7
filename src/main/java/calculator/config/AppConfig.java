package calculator.config;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.CustomDelimiterExtractor;
import calculator.domain.NumberExtractor;
import calculator.domain.StringSplitter;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(
                new InputView(),
                new OutputView(),
                calculatorService());
    }

    public CalculatorService calculatorService() {
        return new CalculatorService(
                new Calculator(),
                numberStringExtractor()
        );
    }

    public NumberExtractor numberStringExtractor() {
        return new NumberExtractor(stringTokenizer());
    }

    public StringSplitter stringTokenizer() {
        return new StringSplitter(new CustomDelimiterExtractor());
    }
}
