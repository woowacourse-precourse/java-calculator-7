package calculator.controller;

import static calculator.service.DelimiterParser.parseDelimiters;

import calculator.dto.CalculatorRequest;
import calculator.dto.CalculatorResponse;
import calculator.view.InputView;
import calculator.view.OutputView;

public class ViewController {
    private final CalculatorController calculatorController;

    public ViewController(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

    public void work() {
        String userInput = InputView.view();
        CalculatorRequest request = parseDelimiters(userInput);
        CalculatorResponse response = calculatorController.calculate(request);
        OutputView.viewResult(response);
    }
}
