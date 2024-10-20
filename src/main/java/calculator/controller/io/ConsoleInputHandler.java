package calculator.controller.io;

import calculator.view.ConsoleView;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {
    private final ConsoleView consoleView = new ConsoleView();

    @Override
    public String getUserInput() {
        consoleView.displayInputMessage();
        return Console.readLine();
    }
}
