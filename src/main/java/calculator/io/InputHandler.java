package calculator.io;

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
        return handleBlankInput(input);
    }

    private String handleBlankInput(String input) {
        if (input.isBlank()) {
            return "0";
        }
        return input;
    }
}