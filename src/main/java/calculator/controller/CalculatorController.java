package calculator.controller;

import calculator.domain.MultipleUseCase;
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
        MultipleUseCase multipleUseCase = new MultipleService();
        int result = multipleUseCase.process(input);
        consoleOutPut.printResult(result);
    }
}
