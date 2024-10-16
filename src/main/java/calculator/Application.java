package calculator;

import calculator.controller.ScenarioRunner;
import calculator.model.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputString inputString = new InputString(InputView.input());

        int calculateResult = ScenarioRunner.runScenario(inputString);

        OutputView.printResult(calculateResult);
    }
}
