package calculator.controller;

import calculator.service.Service;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;

    public CalculatorController(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void calculate() {
        outputView.inputString();
        String input = inputView.inputString();

        List<String> separators = service.createSeparators();
        String customSeparator = service.checkCustomSeparator(input);
        separators.add(customSeparator);
        String numAndSeparator = service.removeCustomPart(input);
        String[] nums = service.separateInput(numAndSeparator, separators);
        int result = service.calculate(nums);

        outputView.outputResult(result);
    }
}
