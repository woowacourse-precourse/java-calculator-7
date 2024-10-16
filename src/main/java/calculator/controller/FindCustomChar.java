package calculator.controller;

import calculator.model.InputString;

public class FindCustomChar {

    private static final int beginIndex = 5;
    private static final int beginCustomIndex = 0;
    private static final int endCustomIndex = 3;
    private static final int CustomCharIndex = 2;

    public void setCustomChar(InputString inputString) {
        String input = inputString.getInput();
        if (input.length() < 4) {
            return;
        }

        if (input.indexOf("//") == beginCustomIndex && input.indexOf("\\n") == endCustomIndex) {
            inputString.setCustomChar(input.charAt(CustomCharIndex));
            inputString.setInput(input.substring(beginIndex));
        } else if (input.indexOf("//") == beginCustomIndex
            && input.indexOf("\\n") == endCustomIndex - 1) {
            inputString.setInput(input.substring(beginIndex - 1));
        }
    }
}
