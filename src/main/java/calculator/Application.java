package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorService calculatorService = new CalculatorService();
        CalculatorController controller = new CalculatorController(inputView, outputView, calculatorService);

        controller.run();
    }
}
