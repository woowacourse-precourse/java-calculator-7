package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String input;

    public InputView() {
        System.out.println(consoleMessage.START_CALCULATE);
        input = Console.readLine();
    }

    public String getInput() {
        return input;
    }

    public void closedConsole() {
        Console.close();
    }
}

