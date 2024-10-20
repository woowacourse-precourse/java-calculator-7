package calculator;

public class Util {
    public boolean checkforInvalidPrefix(String userInput) {
        if (userInput.isEmpty()) {
            return true;
        } else if (Character.isDigit(userInput.charAt(0))) {
            return true;
        } else if (userInput.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }
}
