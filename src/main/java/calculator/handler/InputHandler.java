package calculator.handler;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private String inputString;

    public String inputString() {
        return inputString = Console.readLine();
    }
}
