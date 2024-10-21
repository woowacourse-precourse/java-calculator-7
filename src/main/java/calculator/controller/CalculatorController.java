package calculator.controller;

import calculator.service.CalculatorService;
import calculator.service.OperandService;
import calculator.service.OperatorService;
import calculator.service.Validator;

public class CalculatorController {

    CalculatorService calculatorService;

    public CalculatorController() {
        OperatorService operatorService = OperatorService.initializeDefaultOperator();
        OperandService operandService = new OperandService();
        Validator validator = new Validator();
        this.calculatorService = new CalculatorService(operandService, operatorService, validator);
    }

    public int calculate(String expression) {
        return calculatorService.calculate(expression);
    }

}
