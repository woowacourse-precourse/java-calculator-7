package calculator.domain.controller;


import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.domain.dto.InputDTO;
import calculator.domain.dto.ResultDTO;
import calculator.domain.service.CalculateService;


public class CalculatorController {
    private final CalculateService calculateService;

    public CalculatorController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    public void processCalculation() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        InputDTO inputDTO  = new InputDTO(input);

        ResultDTO resultDTO = calculateService.calculate(inputDTO);
        System.out.println("결과 : " + resultDTO.getResult());
    }
}
