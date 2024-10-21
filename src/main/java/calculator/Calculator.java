package calculator;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    public static void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculate(input);
        System.out.println("결과 : " + result);
    }

    private static int calculate(String input) {
        if (InputValidator.isNullOrEmpty(input)) {
            return 0;
        }
        List<String> operands = Separator.split(input);
        InputValidator.validate(operands);
        return operands.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
