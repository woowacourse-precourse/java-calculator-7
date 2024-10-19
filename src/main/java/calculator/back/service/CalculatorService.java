package calculator.back.service;

import calculator.back.dto.RequestDTO;

public interface CalculatorService {
    Integer calculate(RequestDTO requestDTO);
}
