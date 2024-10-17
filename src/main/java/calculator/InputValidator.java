package calculator;

public class InputValidator {
    private boolean isDefaultDelimiter(String userInput) {

        String[] stringArray = userInput.split("[,:]");
        for (String s : stringArray) {
            if (!s.matches("[+-]?\\d*(\\.\\d+)?")) {
                return false;
            }
        }
        return true;
    }

    private boolean isCustomDelimiter(String userInput) {
        return false;
    }

    public DelimiterType isValidInput(String userInput) {
        if (userInput.isEmpty()) return DelimiterType.EMPTY;
        if (isDefaultDelimiter(userInput)) return DelimiterType.DEFAULT;
        if (isCustomDelimiter(userInput)) return DelimiterType.CUSTOM;
        throw new IllegalArgumentException();
    }
}
