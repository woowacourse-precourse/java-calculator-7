package calculator.controller;

import static calculator.service.container.SeparationServiceType.BASIC;

import calculator.domain.Numbers;
import calculator.service.container.SeparationServiceContainer;
import calculator.service.operation.AddOperationService;
import calculator.service.operation.OperationService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculationController {

    private final SeparationServiceContainer separationServiceContainer;
    private final OperationService addOperationService;

    public CalculationController() {
        separationServiceContainer = new SeparationServiceContainer();
        addOperationService = new AddOperationService();
    }

    public void run() {
        OutputView.printMessage();
        String input = InputView.input();
        Numbers numbers = getNumbers(input);
        int sum = operate(numbers);
        OutputView.printResult(sum);
    }

    private Numbers getNumbers(String input) {
        return separationServiceContainer.getSeparationServices().values().stream()
                .filter(service -> service.hasCustomSeparator(input))
                .findFirst()
                .map(service -> service.getNumbers(input))
                .orElseGet(() -> separationServiceContainer.getSeparationService(BASIC).getNumbers(input));
    }

    private int operate(Numbers numbers) {
        return addOperationService.operate(numbers);
    }
}

