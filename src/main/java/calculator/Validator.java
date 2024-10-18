package calculator;

public class Validator {

    public static boolean isEmptyString(String userInput) {
        return userInput.isEmpty();
    }

    public static boolean hasCustomSplitter(String userInput) {
        return userInput.length() >= 5 && userInput.startsWith("//");
    }

    public static void checkNegativeNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
