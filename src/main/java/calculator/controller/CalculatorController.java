package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private InputView inputView;
    private OutputView outputView;
    private CalculatorService calculatorService;

    public CalculatorController(
            InputView inputView,
            OutputView outputView,
            CalculatorService calculatorService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    public void run() {
        //사용자 입력
        String input = inputView.inputMessage();
        //계산
        int result = calculatorService.calculate(input);

        outputView.outputMessage(String.valueOf(result));
    }
}
