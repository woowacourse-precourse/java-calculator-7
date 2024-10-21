package calculator.controller;

import calculator.domain.dto.CalculatorRequestDto;
import calculator.service.CalculatorService;
import calculator.utils.Messages;

public class CalculatorController {

    private final CalculatorService calculatorService = new CalculatorService();


    public void run(){ Messages.outputStartMessage(); }

    public CalculatorRequestDto inputFormula(){
        String formula = calculatorService.inputFormula();
        String separator = calculatorService.getSeparator(formula);

        String formatFormula = calculatorService.extractFormula(formula);

        return new CalculatorRequestDto(formatFormula, separator);
    }

    public void validateInput(CalculatorRequestDto requestDto){
        calculatorService.validateInput(requestDto);
    }

    public int calculateFormula(CalculatorRequestDto requestDto){
        return calculatorService.calculateFormula(requestDto);
    }

    public void printResult(int result) {
        calculatorService.printResult(result);
    }

}
