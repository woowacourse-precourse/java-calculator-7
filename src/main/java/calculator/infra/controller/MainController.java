package calculator.infra.controller;

import calculator.infra.view.ResultView;
import calculator.model.CalculateSystem;
import calculator.model.io.InputManager;
import calculator.model.io.OutputManager;
import calculator.service.SeparateService;

import java.util.List;

public class MainController {

    private final SeparateService separateService;

    private MainController(SeparateService separateService) {
        this.separateService = separateService;
    }

    public static MainController initiate(SeparateService separateService) {
        return new MainController(separateService);
    }

    public void runCalculator() {
        InputManager inputManager = InputManager.getInstance();
        String input = inputManager.enterInput();

        List<Integer> splittedInput = separateService.separateInput(input);

        CalculateSystem calculateSystem = CalculateSystem.of(splittedInput);
        ResultView resultView = ResultView.from(calculateSystem);

        OutputManager outputManager = OutputManager.getInstance();
        outputManager.offerCalculateResult(resultView);

    }
}
