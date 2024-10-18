package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세.");
        String input = readLine();
        long answer = calculatorService.logic(input);
        System.out.println("결과 : " + answer);
    }
}
