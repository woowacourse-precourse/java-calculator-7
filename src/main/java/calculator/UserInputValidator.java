package calculator;

import java.util.List;

public class UserInputValidator {

    public static boolean validateInputs(String userInput) {
        return userInput.isBlank();
    }

    public static boolean containCustomValidator(String userInput) {
        return userInput.indexOf("//") == 0;
    }

    public static boolean isNumber(List<String> numbers) {
        for (String number : numbers) {
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
