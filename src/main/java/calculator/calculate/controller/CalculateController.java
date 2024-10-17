package calculator.calculate.controller;

import calculator.calculate.dto.request.CalculateRequestDTO;
import calculator.calculate.dto.response.CalculateResponseDTO;
import calculator.calculate.service.CalculateService;

public class CalculateController {

    private final CalculateService calculateService;

    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    public CalculateResponseDTO calculate(CalculateRequestDTO calculateRequestDTO) {
        return calculateService.calculate(calculateRequestDTO);
    }
}
