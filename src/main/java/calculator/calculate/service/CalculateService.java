package calculator.calculate.service;

import calculator.calculate.dto.request.CalculateRequestDTO;
import calculator.calculate.dto.response.CalculateResponseDTO;

public interface CalculateService {

    CalculateResponseDTO calculate(CalculateRequestDTO calculateRequestDTO);
}
