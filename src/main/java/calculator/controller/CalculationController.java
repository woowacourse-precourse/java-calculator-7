package calculator.controller;

import camp.nextstep.edu.missionutils.Console;
import calculator.service.CalculationService;

public class CalculationController {

    private final CalculationService calculationService;

    public CalculationController() {
        this.calculationService = new CalculationService();
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = calculationService.calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}