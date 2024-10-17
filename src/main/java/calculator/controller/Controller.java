package calculator.controller;


import calculator.service.CalculatorService;
import calculator.service.DelimiterService;
import calculator.service.NumberService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Controller {
    private final DelimiterService delimiterService;
    private final NumberService numberService;
    private final CalculatorService calculatorService;

    public Controller(DelimiterService delimiterService, NumberService numberService,
                      CalculatorService calculatorService) {
        this.delimiterService = delimiterService;
        this.numberService = numberService;
        this.calculatorService = calculatorService;
    }

    public void start() {
        InputView.printStartMessage();
        String inputString = InputView.getInput();
        inputString = delimiterService.addCustomDelimiters(inputString);
        numberService.extractNumber(inputString);
        int result = calculatorService.calculate();
        OutputView.printResultMessage(result);
    }
}