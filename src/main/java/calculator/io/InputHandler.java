package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private final InputSeparator inputSeparator = new InputSeparator();

    public UserInput getUserInput() {
        String input = Console.readLine();
        return inputSeparator.separate(input);
    }
}