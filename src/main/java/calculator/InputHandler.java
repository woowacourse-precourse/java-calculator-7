package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputHandler {
    public String getInput() {
        String input;
        try {
            input = Console.readLine();
            return input;
        } catch (NoSuchElementException e) {
            return "";
        }
    }
}
