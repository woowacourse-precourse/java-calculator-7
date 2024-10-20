package calculator;

import calculator.controller.Controller;
import calculator.domain.Calculator;
import calculator.utils.Utils;
import calculator.validators.Validators;
import calculator.view.InputView;
import calculator.view.OutPutView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutPutView(), new Calculator(), new Validators(),
                new Utils());
        controller.calculate();
    }
}
