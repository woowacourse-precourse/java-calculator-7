package calculator.model;

import calculator.exception.CalculateException;
import calculator.util.CalculateCustom;
import calculator.util.CalculateDefault;
import calculator.util.CalculateValidation;
import java.util.List;

public class StringNumbers {

    private static final String ZERO = "0";
    private static final String ZERO_STRING = "";

    private final List<String> splitUserInput;

    public StringNumbers(String userInput) {
        isValidate(userInput);
        this.splitUserInput = createSplitUserInput(userInput);
    }

    public void isValidate(String userInput) {
        CalculateException.catchWrongNumberSeparator(userInput);
    }

    public boolean checkContainCustom(String userInput) {
        return !CalculateCustom.checkNotContainCustom(userInput);
    }

    public boolean checkContainDefault(String userInput) {
        return !CalculateDefault.checkNotContainDefault(userInput);
    }

    public boolean checkIsUserInputZero(String userInput) {
        return userInput.equals(ZERO_STRING);
    }

    public List<String> createSplitUserInput(String userInput) {
        if (checkIsUserInputZero(userInput)) {
            return List.of(ZERO);
        }
        if (checkContainCustom(userInput)) {
            return CalculateCustom.splitWithCustomSeparator(userInput);
        }
        if (checkContainDefault(userInput)) {
            return CalculateDefault.splitWithDefaultSeparator(userInput);
        }
        return List.of(userInput);
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }
}
