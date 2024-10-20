package calculator.infra.controller;

import calculator.common.io.InputManager;
import calculator.common.io.OutputManager;
import calculator.infra.view.ResultView;
import calculator.model.CalculateSystem;
import calculator.service.SeparateService;
import java.util.List;

public class MainController {

    private final SeparateService separateService;

    public MainController(SeparateService separateService) {
        this.separateService = separateService;
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
