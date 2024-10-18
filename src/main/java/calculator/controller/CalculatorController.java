package calculator.controller;

import calculator.model.CalculatorService;
import calculator.model.CalculatorServiceImpl;
import calculator.view.CalculatorInput;
import calculator.view.CalculatorOutput;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    public void calculate() {
        InputView inputView = new CalculatorInput();
        String inputString = inputView.input();

        CalculatorService calculatorService = new CalculatorServiceImpl();
        Integer result = calculatorService.calculate(inputString);

        OutputView outputView = new CalculatorOutput();
        outputView.printResult(result);
    }
}
