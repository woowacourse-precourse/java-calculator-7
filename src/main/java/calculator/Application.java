package calculator;

import calculator.controller.CalculateController;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CalculateController controller = CalculateController.getInstance();

        OutputView.printStart();
        String result = controller.process(InputView.inputNumbers());
        OutputView.printResult(result);

    }
}
