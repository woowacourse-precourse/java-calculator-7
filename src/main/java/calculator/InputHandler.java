package calculator;

import camp.nextstep.edu.missionutils.Console;

import static calculator.enums.CustomDelimiter.CUSTOM_END;
import static calculator.enums.CustomDelimiter.CUSTOM_START;

public class InputHandler {
    public String readInput() {
        return Console.readLine();
    }

    public boolean isCustomDelimiterPresent(String userInput) {
        return userInput.contains(CUSTOM_START.getCustomDelimiter()) && userInput.contains(CUSTOM_END.getCustomDelimiter());
    }

    public char extractCustomDelimiter(String userInput) {
        int customDelimiterStartIndex = userInput.indexOf(CUSTOM_START.getCustomDelimiter());
        int customDelimiterEndIndex = userInput.indexOf(CUSTOM_END.getCustomDelimiter());
        validateCustomDelimiter(customDelimiterStartIndex, customDelimiterEndIndex);

        return userInput.charAt(customDelimiterStartIndex+2);
    }

    private void validateCustomDelimiter(int customDelimiterStartIndex, int customDelimiterEndIndex) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.validateCustomDelimiterFormat(customDelimiterStartIndex, customDelimiterEndIndex);
        inputValidator.validateCustomDelimiterPosition(customDelimiterStartIndex, customDelimiterEndIndex);
    }
}
