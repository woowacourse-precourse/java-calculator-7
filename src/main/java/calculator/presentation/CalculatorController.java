package calculator.presentation;

import calculator.business.CalculatorService;
import calculator.business.dto.CalculatorInputDTO;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    public CalculatorController() {
        System.out.println("덧셈할 문자열을 입력해주세요.");

        CalculatorInputDTO calculatorInputDTO = new CalculatorInputDTO(
                new PresentationValidator().valid(Console.readLine()));

        System.out.println("결과 : " + new CalculatorService().run(calculatorInputDTO).getNumber());
    }
}
