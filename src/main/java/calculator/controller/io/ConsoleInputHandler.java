package calculator.controller.io;

import calculator.view.ConsoleView;
import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputHandler implements InputHandler {
    private final ConsoleView consoleView = new ConsoleView();

    @Override
    public String getUserInput() {
        //인풋을 위한 메시지 출력 view 호출
        consoleView.displayInputMessage();
        return Console.readLine();
    }
}
