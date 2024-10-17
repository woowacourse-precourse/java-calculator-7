package calculator.ui;

import calculator.application.CalculatorService;
import calculator.application.dto.CalculatorSumRequest;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void stringAdditionCalculate() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculatorService.splitAndSum(new CalculatorSumRequest(input));
        System.out.println("결과 : " + result);
    }

}
