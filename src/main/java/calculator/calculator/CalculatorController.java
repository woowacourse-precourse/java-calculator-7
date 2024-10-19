package calculator.calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class CalculatorController {
    private static final String INITIAL_COMMENT = "덧셈할 문자열을 입력해 주세요.";

    private static final String RESULT = "결과 : ";

    private final Calculator calculator;

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        System.out.println(INITIAL_COMMENT);
        String input = Console.readLine();
        BigInteger result = calculator.calculate(input);
        System.out.println(RESULT + result);
        Console.close();
    }
}
