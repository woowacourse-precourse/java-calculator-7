package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputHandler {
    public String getInput() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "0";
        }
    }
}