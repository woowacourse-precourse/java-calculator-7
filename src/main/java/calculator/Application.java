package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.CalculatorControllerImpl;
import calculator.model.StringCalculator;
import calculator.model.StringCalculatorImpl;
import calculator.view.CalculatorView;
import calculator.view.CalculatorViewImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StringCalculator model = new StringCalculatorImpl();
        CalculatorView view = new CalculatorViewImpl();
        CalculatorController controller = new CalculatorControllerImpl(model, view);

        controller.run();

    }
}
