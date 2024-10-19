package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String responseString() {
        String input = Console.readLine().trim();
        return validateEmptyInput(input);
    }

    private String validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }
        return input;
    }
}
