package calculator.controller;

import calculator.service.CalculatorService;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    public final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void getUserInput() {
        String input;
        int result;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();

        result = calculatorService.getUserInput(input);

        System.out.println("결과 : " + result);
    }
}
