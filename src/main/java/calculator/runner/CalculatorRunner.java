package calculator.runner;

import calculator.core.Calculator;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorRunner {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Console.close();

        Calculator calculator = Calculator.of(input);
        System.out.println("결과 : " + calculator.sum());
    }
}
