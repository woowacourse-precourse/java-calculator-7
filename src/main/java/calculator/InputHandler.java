package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getInput() {
        String inputStr = Console.readLine();

        if (inputStr.isEmpty()) {
            return "";
        }
        return inputStr;
    }
}
