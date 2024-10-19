package calculator.util;

public class CalculateValidation {

    private static final Integer ZERO = 0;
    private static final String ZERO_STRING = "";

    public static boolean checkNotContainAllSeparator(String userInput) {
        return CalculateDefault.checkNotContainDefault(userInput) && CalculateCustom.checkNotContainCustom(userInput);
    }

    public static boolean checkIsNumberPositive(Integer number){
        return number < ZERO;
    }

    public static boolean checkIsNotCustomPreCorrect(String userInput) {
        return !CalculateCustom.getCustomPreIndex(userInput).equals(ZERO);
    }

    public static boolean checkIsNotUserInputZero(String userInput) {
        return !userInput.equals(ZERO_STRING);
    }

    public static boolean checkIsNotUserInputNumber(String userInput) {
        return !userInput.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
