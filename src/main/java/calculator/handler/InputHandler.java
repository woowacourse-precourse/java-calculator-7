package calculator.handler;

import static calculator.constant.Message.*;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String getInput() {
        System.out.println(CALCULATOR_START_MESSAGE);
        return Console.readLine();
    }
}
