package calculator;

import calculator.controller.CalculatorController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculatorController controller = new CalculatorController(inputView);

        while (true) {
            try {
                int result = controller.processInput();
                outputView.printResult(result);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
                break;
            }
        }
        inputView.close();
    }
}

