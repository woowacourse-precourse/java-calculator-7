package calculator;

import calculator.controller.ScenarioRunner;
import calculator.model.InputString;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputString inputString = new InputString(InputView.input());

        ScenarioRunner scenarioRunner = new ScenarioRunner(inputString);
        int calculateResult = scenarioRunner.runScenario();

        OutputView.printResult(calculateResult);
    }
}
