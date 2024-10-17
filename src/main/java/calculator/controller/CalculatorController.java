package calculator.controller;


public class CalculatorController {

    public void run() {
        CalculatorInputer calculatorInputer = new CalculatorInputer();
        String inputString = calculatorInputer.getInput();

        CalculatorService calculatorService = new CalculatorService();
        result = calculatorService.calculateSumString(inputString);

        CalculatorOutputer calculatorOutputer = new CalculatorOutputer();
        calculatorOutputer.printResult(result);
    }

}
