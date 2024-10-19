package calculator.util;

public class CalculateValidation {

    private static final Integer ZERO = 0;

    public static boolean checkNotContainAllSeparator(String userInput) {
        return CalculateDefault.checkNotContainDefault(userInput) && CalculateCustom.checkNotContainCustom(userInput);
    }

    public static boolean checkIsNumberPositive(Integer number){
        return number < ZERO;
    }

    public static boolean checkIsNotCustomPreCorrect(String userInput) {
        return !CalculateCustom.getCustomPreIndex(userInput).equals(ZERO);
    }
}
