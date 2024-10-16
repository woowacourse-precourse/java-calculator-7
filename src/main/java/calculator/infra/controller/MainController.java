package calculator.infra.controller;

import calculator.infra.view.ResultView;
import calculator.model.CalculateSystem;
import calculator.model.io.InputManager;
import calculator.model.io.OutputManager;
import calculator.model.separate.SeparateManager;

import java.util.List;

public class MainController {

    private MainController() { }

    public static MainController initiate() {
        return new MainController();
    }

    public void runCalculator() {
        InputManager inputManager = InputManager.getInstance();
        String input = inputManager.enterInput();

        SeparateManager separateManager = SeparateManager.initiate();
        separateManager.extractCustomDelimiter(input);
        List<Integer> splittedInput = separateManager.split(input);

        CalculateSystem calculateSystem = CalculateSystem.of(splittedInput);
        ResultView resultView = ResultView.from(calculateSystem);

        OutputManager outputManager = OutputManager.getInstance();
        outputManager.offerCalculateResult(resultView);

    }
}
