package calculator.presentation;

import static calculator.common.Constant.INPUT_MESSAGE;
import static calculator.common.Constant.RESULT_MESSAGE;

import calculator.business.CalculatorService;
import calculator.business.dto.CalculatorInputDTO;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    public CalculatorController() {
        System.out.println(INPUT_MESSAGE);

        CalculatorInputDTO calculatorInputDTO = new CalculatorInputDTO(
                new PresentationValidator().valid(Console.readLine()));

        System.out.println(RESULT_MESSAGE + new CalculatorService().run(calculatorInputDTO).getNumber());
    }
}
