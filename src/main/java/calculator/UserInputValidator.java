package calculator;

import java.util.List;

import static calculator.PrintText.CUSTOM_DEL_PRE_SEPERATOR;

public class UserInputValidator {

    public boolean validateInputs(String userInput) {
        return userInput.isBlank();
    }

    public boolean containCustomValidator(String userInput) {
        return userInput.indexOf(CUSTOM_DEL_PRE_SEPERATOR.getValue()) == PRE_CUSTOM_DEL_INDEX;
    }

    public boolean isNumber(List<String> numbers) {
        for (String number : numbers) {
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) throw new IllegalArgumentException();
            }
        }
        return true;
    }

    private final int PRE_CUSTOM_DEL_INDEX = 0;
}
