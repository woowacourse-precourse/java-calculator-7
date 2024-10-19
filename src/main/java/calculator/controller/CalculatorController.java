package calculator.controller;

import calculator.console.ConsoleReader;
import calculator.service.CalculatorService;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView;
    private final CalculatorService calculatorService;
    private final ConsoleReader consoleReader;
    public CalculatorController(OutputView outputView, CalculatorService calculatorService,
                                ConsoleReader consoleReader) {
        this.outputView = outputView;
        this.calculatorService = calculatorService;
        this.consoleReader = consoleReader;
    }

    public void run(){
        outputView.start();
        int result = calculatorService.calculate(consoleReader.read());
        outputView.printResult(result);
    }

}
