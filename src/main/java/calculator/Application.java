package calculator;

import calculator.back.controller.CalculatorController;
import calculator.back.frontcontroller.FrontController;
import calculator.back.resolver.ArgumentResolver;
import calculator.back.service.impl.CalculatorServiceImpl;
import calculator.front.view.InputView;
import calculator.front.view.OutputView;

public class Application {
    public static void main(String[] args) {
        FrontController controller = new FrontController(new InputView(), new OutputView(), new ArgumentResolver(),
                new CalculatorController(new CalculatorServiceImpl()));
        controller.run();
    }
}
