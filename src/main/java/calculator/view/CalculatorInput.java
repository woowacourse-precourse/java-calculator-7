package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorInput {

    public static String inputString() {
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
