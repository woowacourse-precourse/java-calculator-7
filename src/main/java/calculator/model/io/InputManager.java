package calculator.model.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

import static calculator.common.message.IOMessage.ENTER_INPUT;

public class InputManager implements IOManager{

    private static InputManager inputManager;

    // Constructor
    private InputManager() { }

    public static InputManager getInstance() {
        if (Objects.isNull(inputManager)) {
            inputManager = new InputManager();
        }
        return inputManager;
    }

    // Method
    public String enterInput() {
        printMessage(ENTER_INPUT);
        String input = Console.readLine();
        printMessage(input);
        return input;
    }
}
