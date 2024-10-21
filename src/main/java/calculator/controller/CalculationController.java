package calculator.controller;

import calculator.model.DelimiterGroup;
import calculator.model.Operand;
import calculator.model.Result;
import calculator.service.CalculationService;
import calculator.service.Converter;
import calculator.service.TokenizationService;
import calculator.view.CalculationView;
public class CalculationController {

    private final TokenizationService tokenizationService;
    private final CalculationService calculationService;
    private final Converter converter;
    private final CalculationView calculationView;

    public CalculationController(TokenizationService tokenizationService, CalculationService calculationService,
                                 Converter converter, CalculationView calculationView) {
        this.tokenizationService = tokenizationService;
        this.calculationService = calculationService;
        this.converter = converter;
        this.calculationView = calculationView;
    }

    public void calculate() {

        String input = calculationView.getInput();
        
        DelimiterGroup delimiterGroup = tokenizationService.makeDelimiterGroup(input);      

        String[] operandStrings = tokenizationService.tokenize(input, delimiterGroup);      // 구분자를 기준으로 수식에서 피연산자 파싱

        Operand[] operands = new Operand[operandStrings.length];                            // 피연산자
        for (int i = 0; i < operandStrings.length; i++) {
            operands[i] = converter.convertToOperand(operandStrings[i]);
        }

        Result sum = calculationService.sum(operands);                                      // 계산

        calculationView.displayResult(sum);
    }
}
