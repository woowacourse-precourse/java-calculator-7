package calculator.domain.controller;


import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.domain.dto.InputDTO;
import calculator.domain.dto.ResultDTO;
import calculator.domain.service.CalculatorService;


public class CalculatorController {
    private final CalculatorService calculateService;

    public CalculatorController(CalculatorService calculateService) {
        this.calculateService = calculateService;
    }

    //사용자에게 readLine()으로 입력을 받아 계산을 하는 기능
    public void processCalculation() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        //InputDTO 객체를 새로 생성하여 값을 서비스로 전달
        InputDTO inputDTO  = new InputDTO(input);
        //calculateService를 통해서  연산하여 값을 반환
        ResultDTO resultDTO = calculateService.calculate(inputDTO);
        System.out.println("결과 : " + resultDTO.getResult());
    }
}
