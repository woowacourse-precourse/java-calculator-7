package calculator.service;

import calculator.dto.CalculationDTO;
import calculator.model.CalculationResult;

public class CalculatorService {

  public CalculationResult calculate(String inputData) {

    CalculationDTO calculationDTO = new CalculationDTO();
    calculationDTO.calculate(inputData);

    return calculationDTO.toModel();
  }
}
