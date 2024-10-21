package calculator.view.handler;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {

    @Override
    public String inputValue() {
        return Console.readLine();
    }
}
