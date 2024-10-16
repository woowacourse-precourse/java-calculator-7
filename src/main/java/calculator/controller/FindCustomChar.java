package calculator.controller;

import calculator.model.InputString;

public class FindCustomChar {

    private static final int BEGIN_INDEX = 5;
    private static final int BEGIN_CUSTOM_INDEX = 0;
    private static final int END_CUSTOM_INDEX = 3;
    private static final int CUSTOM_CHAR_INDEX = 2;

    public static void setCustomChar(InputString inputString) {
        String input = inputString.getInput();
        if (input.length() < 4) {
            return;
        }

        if (input.indexOf("//") == BEGIN_CUSTOM_INDEX && input.indexOf("\\n") == END_CUSTOM_INDEX) {
            inputString.setCustomChar(input.charAt(CUSTOM_CHAR_INDEX));
            inputString.setInput(input.substring(BEGIN_INDEX));
        } else if (input.indexOf("//") == BEGIN_CUSTOM_INDEX
            && input.indexOf("\\n") == END_CUSTOM_INDEX - 1) {
            inputString.setInput(input.substring(BEGIN_INDEX - 1));
        }
    }
}
