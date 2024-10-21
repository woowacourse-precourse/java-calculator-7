package calculator.service;

import java.util.List;

public class CalculatorService {

    OperandService operandService;
    OperatorService operatorService;
    Validator validator;

    public CalculatorService(OperandService operandService, OperatorService operatorService, Validator validator) {
        this.operandService = operandService;
        this.operatorService = operatorService;
        this.validator = validator;
    }

    public int calculate(String expression) {
        String[] expressionArr = operatorService.extractCustomOperators(expression).split("");
        validator.validateLetterContain(expressionArr);
        operatorService.indexingOperators(expressionArr);
        operandService.indexingOperands(expressionArr);

        int result = 0;
        List<Integer> operands = operandService.operands;
        for (Integer operand : operands) {
            result += operand;
        }
        return result;
    }

}
