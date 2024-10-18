package calculator.presentation;

import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorRunner {
    public static void run() {
        String userInput = Console.readLine();
        CalculatorService.printResultOfSum(userInput);
    }
}
