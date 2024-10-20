package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.RequestView;
import calculator.view.ResponseView;

public class CalculatorController {
    private final RequestView requestView;
    private final ResponseView responseView;
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.requestView = RequestView.getInstance();
        this.responseView = ResponseView.getInstance();
        this.calculatorService = CalculatorService.getInstance();
    }

    public void calc() {
        String input = requestView.readLine();
        int result = calculatorService.calc(input);
        responseView.print(result);
    }
}
