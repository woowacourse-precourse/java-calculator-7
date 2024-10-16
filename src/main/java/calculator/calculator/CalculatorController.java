package calculator.calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private static final String INITIAL_COMMENT = "덧셈할 문자열을 입력해 주세요.";

    private static final String RESULT = "결과 : ";

    public void run() {
        System.out.println(INITIAL_COMMENT);
        Calculator calculator = new Calculator();
        String input = Console.readLine();
        int result = calculator.calculate(input);
        System.out.println(RESULT + result);
        Console.close();
    }
}
