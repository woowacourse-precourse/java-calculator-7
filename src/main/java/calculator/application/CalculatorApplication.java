package calculator.application;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
    public void run(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController controller = new CalculatorController(inputView, outputView);
        controller.run();
    }
}
