package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String readInput() {
        return Console.readLine();
    }

    public boolean isCustomDelimiterPresent(String userInput) {
        return userInput.contains("//") && userInput.contains("\\n");
    }

    public char extractCustomDelimiter(String userInput) {
        int customDelimiterStartIndex = userInput.indexOf("//") + 2;
        int customDelimiterEndIndex = userInput.indexOf("\\n") - 1;

        InputValidator inputValidator = new InputValidator();
        inputValidator.validateCustomDelimiterFormat(customDelimiterStartIndex, customDelimiterEndIndex);

        return userInput.charAt(customDelimiterStartIndex);
    }
}
