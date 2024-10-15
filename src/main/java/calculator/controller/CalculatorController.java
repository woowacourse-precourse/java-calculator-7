package calculator.controller;

import calculator.Calculator;
import calculator.service.CalculatorService;
import calculator.service.CalculatorServiceImpl;
import calculator.view.InputView;
import java.util.List;

public class CalculatorController {

    private CalculatorService calculatorService = new CalculatorServiceImpl();
    private Calculator calculator = new Calculator();
    private InputView inputView = new InputView();

    public void start(){
        String s = inputView.getUserInput();
        List<String> validNumber = calculatorService.findValidNumber(s);
        long result = calculator.calculatePlusNumber(validNumber);
        System.out.println("결과 : " + result);
    }

}
