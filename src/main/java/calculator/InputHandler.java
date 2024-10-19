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
        int customDelimiterStartIndex = userInput.indexOf("//");
        int customDelimiterEndIndex = userInput.indexOf("\\n");
        validateCustomDelimiter(customDelimiterStartIndex, customDelimiterEndIndex);

        return userInput.charAt(customDelimiterStartIndex+2);
    }

    private void validateCustomDelimiter(int customDelimiterStartIndex, int customDelimiterEndIndex) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateCustomDelimiterFormat(customDelimiterStartIndex, customDelimiterEndIndex);
        inputValidator.validateCustomDelimiterPosition(customDelimiterStartIndex, customDelimiterEndIndex);
    }
}
