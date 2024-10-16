package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            String input = inputView.inputMessage();
            int result = calculatorService.calculate(input);
            outputView.outputMessage(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); //outputView 기능으로 추가할 것
        }
    }
}
