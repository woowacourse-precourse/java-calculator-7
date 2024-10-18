package calculator.domain;

import calculator.domain.handler.InputHandler;
import calculator.domain.view.OutputView;

public class CalculatorController {
    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.inputHandler = new InputHandler();
        this.outputView = new OutputView();
        this.calculatorService = new CalculatorService();
    }

    public void run() {
        String input = inputHandler.getInput();
        int result = calculatorService.calculate(input);
        outputView.outputMessage(result);
    }
}
