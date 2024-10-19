package calculator.controller;

import calculator.domain.Operator;
import calculator.domain.number.Number;
import calculator.domain.number.Numbers;
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
        Numbers numbers = separatorHandler.process(UIController.receive());
        Number result = calculatorService.operate(Operator.PLUS, numbers);

        UIController.printSumResult(result.getValue());
    }
}
