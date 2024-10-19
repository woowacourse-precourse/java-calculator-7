package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorUi {

    private final CalculatorManager calculatorManager;

    public CalculatorUi(CalculatorManager calculatorManager) {
        this.calculatorManager = calculatorManager;
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        String input = Console.readLine();
        int result = calculatorManager.calculate(input);
        System.out.println("결과 : " + result);
    }
}
