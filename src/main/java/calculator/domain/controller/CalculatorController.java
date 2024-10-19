package domain.controller.controller;

import dto.InputDTO;
import dto.ResultDTO;
import service.CalculateService;

public class CalculatorController {
    private final CalculateService calculateService;

    public CalculatorController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    public void processCalculation(String input) {
        InputDTO inputDTO = new InputDTO(input);
        ResultDTO resultDTO = calculateService.calculate(inputDTO);
        System.out.println("계산 결과: " + resultDTO.getResult());
    }
}
