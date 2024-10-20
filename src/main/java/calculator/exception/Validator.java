package calculator.exception;

public class Validator {

    public static boolean isEmptyString(String userInput) {
        return userInput.isEmpty();
    }

    public static boolean hasCustomSplitter(String userInput) {
        return userInput.length() >= 5 && userInput.startsWith("//");
    }

    public static void checkNegativeNumber(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NEGATIVE_NUM);
        }
    }

    public static Long isNumeric(String splitInput) {
        long number;
        try {
            number = Long.parseLong(splitInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CONVERTED_NUM);
        }
        return number;
    }
}
