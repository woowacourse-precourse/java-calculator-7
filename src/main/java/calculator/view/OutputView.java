package calculator.view;

import calculator.dto.CalculationResponseDTO;

public class OutputView {
    public void outputCalculationResponseDTO(CalculationResponseDTO calculationResponseDTO) {
        System.out.println("결과 : " + calculationResponseDTO.getSumResult());
    }
}
