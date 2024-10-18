package calculator.Utils;

public class InputValidator {

    public boolean validateNumericCharacters(String[] userInput) {
        for (String string : userInput) {
            if (containsNonNumericCharacters(string)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public boolean validateEmptyInput(String userInput) {
        return userInput.isEmpty();
    }

    public boolean containsNonNumericCharacters(String input) {
        return input.matches(".*[^0-9].*");
    }

}
