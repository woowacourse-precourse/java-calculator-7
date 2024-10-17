package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculatorService;
import calculator.view.CalculatorView;
import calculator.view.OutputView;

public class Calculator {

    private final OutputView outputView;
    private final CalculatorService calculatorService;
    private final CalculatorController calculatorController;
    private final CalculatorView calculatorView;

    public Calculator() {
        this.outputView = new OutputView();
        this.calculatorService = new CalculatorService();
        this.calculatorController = new CalculatorController(calculatorService);
        this.calculatorView = new CalculatorView(calculatorController);
    }

    public void start() {
        try {
            outputView.printStartMessage();
            int result = calculatorView.startProgram();
            outputView.printResult(result);
        } catch (Exception e) {
            outputView.printErrorMessage(e);
            throw e;
        }
    }
}
