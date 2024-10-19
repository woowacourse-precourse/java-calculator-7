package calculator.back.controller;

import calculator.back.dto.RequestDTO;
import calculator.back.service.CalculatorService;
import calculator.back.dto.ResponseDTO;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculateService) {
        this.calculatorService = calculateService;
    }

    public ResponseDTO calculate(RequestDTO requestDTO) {
        return new ResponseDTO(String.valueOf(calculatorService.calculate(requestDTO)));
    }
}
