package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {
    private void printStartText() {
        System.out.println(Constants.MESSAGE_START_INPUT);
    }

    private String inputData() {
        return Console.readLine();
    }
}
