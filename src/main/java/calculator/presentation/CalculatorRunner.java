package calculator.presentation;

import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorRunner {
    public static void run() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String userInput = Console.readLine();
        CalculatorService.printResultOfSum(userInput);
    }
}
