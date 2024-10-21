package calculator;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.validator.StringCalculatorValidator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        StringCalculatorValidator validator = new StringCalculatorValidator();
        StringCalculator model = new StringCalculator();
        OutputView outputView = new OutputView();

        CalculatorController controller = new CalculatorController(inputView, validator, model, outputView);
        controller.run();
    }
}
