package calculator.handler;

import static calculator.constants.Constants.INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String getInputString() {
        System.out.println(INPUT_MESSAGE);
        String inputString = Console.readLine();
        return inputString;
    }
}
