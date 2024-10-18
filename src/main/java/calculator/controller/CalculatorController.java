package calculator.controller;

import calculator.model.Calculator;
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
        String userInput = inputView.getUserInput();
        List<String> validNumber = calculatorService.findValidNumber(userInput);
        double calculateResult = calculator.calculatePlusNumber(validNumber);
        Object determineResultType = calculator.determine_type(calculateResult);
        outputView.printResult(determineResultType);
    }

}
