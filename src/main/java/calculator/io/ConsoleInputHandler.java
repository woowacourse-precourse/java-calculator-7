package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler{

    @Override
    public String getUserInput() {
        return Console.readLine();
    }
}
