package calculator.controller;

import calculator.domain.Operator;
import calculator.service.calculator.CalculatorService;
import calculator.service.separator.SeparatorHandler;

public class Calculator {

    SeparatorHandler separatorHandler;
    CalculatorService calculatorService;

    public Calculator(SeparatorHandler separatorHandler,
                      CalculatorService calculatorService) {
        this.separatorHandler = separatorHandler;
        this.calculatorService = calculatorService;
    }

    public void run() {
        UIController.printSumResult(
                calculatorService.operate(Operator.PLUS,
                        separatorHandler.process(UIController.receive()))
        );
    }
}
