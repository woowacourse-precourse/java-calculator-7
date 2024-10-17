package calculator.controller;

import calculator.service.CalculatorService;

import java.util.Scanner;

public class CalculatorController {

    public final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void getUserInput() {
        String input;
        String result;

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();

        result = calculatorService.getUserInput(input);

        System.out.println("결과 : " + result);
    }
}
