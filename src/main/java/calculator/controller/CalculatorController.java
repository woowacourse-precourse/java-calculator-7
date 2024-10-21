package calculator.controller;

import calculator.dto.CalculatorRequestDto;
import calculator.dto.CalculatorResponseDto;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorService = new CalculatorService();
    }

    private CalculatorResponseDto calculator(CalculatorRequestDto calculatorRequestDto) {
        final String result = calculatorService.calculate(calculatorRequestDto.input());

        return new CalculatorResponseDto(result);
    }

    public void run() {
        CalculatorRequestDto calculatorRequestDto = InputView.beginInput();
        OutputView.printResult(calculator(calculatorRequestDto).result());
    }

}
