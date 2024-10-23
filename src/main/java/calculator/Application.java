package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {

        CalculatorService calculatorService = new CalculatorService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController controller = new CalculatorController(calculatorService, inputView, outputView);
        controller.run();
    }
}
