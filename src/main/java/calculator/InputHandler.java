package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private static final String ZERO = "0";

    public String input() {
        String input = Console.readLine();
        return processInput(input);
    }

    public String processInput(String input) {
        if (input == null || input.isBlank()) {
            return ZERO;
        }
        return input.trim();
    }
}
