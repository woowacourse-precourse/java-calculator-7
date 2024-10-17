package calculator.util;

import calculator.model.Numbers;
import calculator.model.StringNumbers;
import java.util.List;

public class Calculate {

    private static final Integer ZERO = 0;

    public static Integer calculateUserInputSum(String userInput) {
        return calculateSplitUserInputSum(calculateSplitUserInput(userInput));
    }

    public static List<String> calculateSplitUserInput(String userInput) {
        return new StringNumbers(userInput).getSplitUserInput();
    }

    public static Integer calculateSplitUserInputSum(List<String> userInput) {
        return new Numbers(userInput).calculateNumbersSum();
    }

    public static boolean checkNotContainAllSeparator(String userInput) {
        return CalculateDefault.checkNotContainDefault(userInput) && CalculateCustom.checkNotContainCustom(userInput);
    }

    public static boolean checkIsNumberPositive(Integer number){
        return number < ZERO;
    }
}
