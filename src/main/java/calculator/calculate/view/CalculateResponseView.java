package calculator.calculate.view;

import calculator.calculate.dto.response.CalculateResponseDTO;

public class CalculateResponseView {

    private static final String CALCULATE_RESPONSE_MESSAGE = "결과 : ";

    public static void response(CalculateResponseDTO calculateResponseDTO) {
        System.out.println(CALCULATE_RESPONSE_MESSAGE + calculateResponseDTO.result());
    }
}
