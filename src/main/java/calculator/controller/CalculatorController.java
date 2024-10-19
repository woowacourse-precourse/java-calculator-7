package calculator.controller;

import calculator.dto.CalculatorRequestDto;
import calculator.dto.CalculatorResponseDto;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();

    public void start() {
        InputView inputView = new InputView();
        String input = inputView.print();

        CalculatorRequestDto requestDto = new CalculatorRequestDto(input);
        CalculatorResponseDto responseDto = calculatorService.sum(requestDto);
        long sumResult = responseDto.sumResult();

        OutputView outputView = new OutputView();
        outputView.print(sumResult);
    }
}
