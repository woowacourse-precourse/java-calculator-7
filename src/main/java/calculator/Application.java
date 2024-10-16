package calculator;

import calculator.controller.ApplicationController;
import calculator.model.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputString inputString = new InputString(InputView.input());

        ApplicationController applicationController = new ApplicationController(inputString);
        int calculateResult = applicationController.ApplicationStart();

        OutputView.printResult(calculateResult);
    }
}
