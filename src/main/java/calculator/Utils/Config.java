package calculator.Utils;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.DelimiterExtractor;
import calculator.model.DelimiterProcessor;
import calculator.model.NumberParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Config {
    public CalculatorController calculatorController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        DelimiterProcessor delimiterProcessor = new DelimiterProcessor();
        NumberParser numberParser = new NumberParser();
        Calculator calculator = new Calculator();
        NumberFormatter numberFormatter = new NumberFormatter();
        InputValidator inputValidator = new InputValidator();

        return new CalculatorController(
                inputView, outputView, delimiterExtractor, delimiterProcessor,
                numberParser, calculator, numberFormatter, inputValidator
        );
    }
}
