package calculator;

import calculator.controller.Controller;
import calculator.domain.Calculator;
import calculator.utils.Utils;
import calculator.validators.Validators;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), new Calculator(), new Validators(),
                new Utils());
        controller.calculate();
    }
}
