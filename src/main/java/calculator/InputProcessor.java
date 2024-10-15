package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {
    private static InputProcessor instance;

    private InputProcessor() {
    }

    public static InputProcessor getInstance() {
        if (instance == null) {
            instance = new InputProcessor();
        }
        return instance;
    }

    public void getInput() {
        String input = Console.readLine();
    }
}
