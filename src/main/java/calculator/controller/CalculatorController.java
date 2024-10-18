package calculator.controller;


import calculator.service.CalculatorService;
import calculator.view.CalculatorInputer;
import calculator.view.CalculatorOutputer;

public class CalculatorController {
    private final CalculatorOutputer calculatorOutputer;
    private final CalculatorInputer calculatorInputer;
    private final CalculatorService calculatorService;

    public CalculatorController() {
        this.calculatorOutputer = new CalculatorOutputer();
        this.calculatorInputer = new CalculatorInputer();
        this.calculatorService = new CalculatorService();
    }

    public void processSumStringCalculation() {
        calculatorOutputer.printIntro();
        String inputString = calculatorInputer.getInput();

        int result = calculatorService.calculateSumString(inputString);

        calculatorOutputer.printResult(result);
    }
}
