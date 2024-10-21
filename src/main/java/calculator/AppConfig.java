package calculator;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(calculatorService(), inputView(), outputView());
    }

    public CalculatorService calculatorService() {
        return new CalculatorService(stringCalculator());
    }

    public StringCalculator stringCalculator() {
        return new StringCalculator();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}