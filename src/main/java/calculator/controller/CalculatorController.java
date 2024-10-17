package calculator.controller;


import calculator.service.CalculatorService;
import calculator.view.CalculatorInputer;
import calculator.view.CalculatorOutputer;

public class CalculatorController {

    public void run() {
        CalculatorOutputer calculatorOutputer = new CalculatorOutputer();
        calculatorOutputer.printIntro();

        CalculatorInputer calculatorInputer = new CalculatorInputer();
        String inputString = calculatorInputer.getInput();

        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.calculateSumString(inputString);

        calculatorOutputer.printResult(result);
    }

}
