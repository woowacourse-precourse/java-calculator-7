package calculator.controller;

import calculator.domain.Operator;
import calculator.domain.number.Number;
import calculator.service.calculator.CalculatorService;
import calculator.service.separator.SeparatorService;

public class Calculator {

    SeparatorService separatorService;
    CalculatorService calculatorService;

    public Calculator(SeparatorService separatorService,
                      CalculatorService calculatorService) {
        this.separatorService = separatorService;
        this.calculatorService = calculatorService;
    }

    public void run() {
        Number result = calculatorService.operate(
                Operator.PLUS, separatorService.separate(UIController.receive())
        );

        UIController.printSumResult(result.getValue());
    }
}
