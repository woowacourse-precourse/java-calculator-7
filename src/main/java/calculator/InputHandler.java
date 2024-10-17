package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getInput() {
        String str;
        try {
            str = Console.readLine();
        } catch (Exception e) {
            return "";
        }
        return str;
    }
}
