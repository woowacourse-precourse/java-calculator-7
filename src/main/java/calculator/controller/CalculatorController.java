package calculator.controller;

import calculator.Calculator;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class CalculatorController {

    private CalculatorService calculatorService = new CalculatorServiceImpl();
    private Calculator calculator = new Calculator();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start(){
        String s = inputView.getUserInput();
        List<String> validNumber = calculatorService.findValidNumber(s);
        long result = calculator.calculatePlusNumber(validNumber);
        outputView.printResult(result);
    }

}
