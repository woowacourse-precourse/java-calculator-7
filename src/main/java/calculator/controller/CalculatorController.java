package calculator.controller;

import calculator.domain.CalculatorUseCase;
import calculator.service.MultipleService;
import calculator.view.ConsoleInput;
import calculator.view.ConsoleOutPut;

public class CalculatorController {
    private final ConsoleInput consoleInput;
    private final ConsoleOutPut consoleOutPut;

    public CalculatorController() {
        this.consoleInput = new ConsoleInput();
        this.consoleOutPut = new ConsoleOutPut();
    }

    public void run() {
        String input = consoleInput.input();
        CalculatorUseCase multipleUseCase = new MultipleService();
        int result = multipleUseCase.calculate(input);
        consoleOutPut.render(result);
    }
}
