package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {

    public String readInput() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("Input cannot be null");
        }
    }
}