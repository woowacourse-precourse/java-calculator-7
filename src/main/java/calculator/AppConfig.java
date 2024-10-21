package calculator;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class AppConfig {

    public CalculatorController calculatorController() {
        return new CalculatorController(stringCalculator(), inputView(), outputView());
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