package calculator.controller;

import static calculator.container.SeparationServiceType.BASIC;

import calculator.container.SeparationServiceContainer;
import calculator.service.dto.NumbersDto;
import calculator.service.dto.SumDto;
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
        NumbersDto numbersDto = getNumbers(input);
        SumDto sumDto = operate(numbersDto);
        OutputView.printResult(sumDto);
    }

    private NumbersDto getNumbers(String input) {
        return separationServiceContainer.getSeparationServices().values().stream()
                .filter(service -> service.hasCustomSeparator(input))
                .findFirst()
                .map(service -> service.getNumbers(input))
                .orElseGet(() -> separationServiceContainer.getSeparationService(BASIC).getNumbers(input));
    }

    private SumDto operate(NumbersDto numbersDto) {
        return addOperationService.operate(numbersDto);
    }
}

