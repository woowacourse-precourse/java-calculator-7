package calculator.util;

import calculator.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputHandler {
    public String getInput() {
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        }
        return InputValidator.handleBlankInput(input);
    }
}
