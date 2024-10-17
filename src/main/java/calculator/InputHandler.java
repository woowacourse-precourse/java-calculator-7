package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputHandler {
    public String getInput() {
        String input;
        try {
            input = Console.readLine();
            if (input.startsWith("//") && input.length() == 3) {
                input = input + "\\n" +Console.readLine();
            }
            return input;
        } catch (NoSuchElementException e) {
            return "0";
        }
    }
}
