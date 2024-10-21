package calculator.controller;

import calculator.service.Service;
import calculator.view.InputView;
import calculator.view.OutputView;

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

        service.createSeparators();
        if (service.isCustomSeparator(input)) {
            service.saveCustomSeparator(input);
            input = service.removeCustomPart(input);
        }

        String[] nums = service.separateInput(input);
        int result = service.calculate(nums);

        outputView.outputResult(result);
    }
}
