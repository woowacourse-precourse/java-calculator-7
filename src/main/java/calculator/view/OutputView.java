package calculator.view;

import calculator.dto.CalculationResultDTO;

public class OutputView {
    public static void printResult(CalculationResultDTO resultDTO) {
        System.out.printf(ViewMessages.RESULT_MESSAGE + resultDTO.result());
    }
}
