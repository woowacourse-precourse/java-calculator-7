package calculator.view;

import calculator.dto.ResultDTO;
import static calculator.view.ViewMessages.CALCULATION_RESULT_MESSAGE;
import static calculator.view.ViewMessages.REQUIRE_OPERAND_STRING_MESSAGE;

public class OutputView {
    public static void printRequireOperandStringMessage(){
        System.out.println(REQUIRE_OPERAND_STRING_MESSAGE);
    }

    public static void printCalculationResultMessage(ResultDTO resultDto){
        System.out.println(CALCULATION_RESULT_MESSAGE + resultDto.getCalculationResult());
    }
}