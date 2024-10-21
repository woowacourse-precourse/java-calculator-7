package calculator.util;

import calculator.model.Numbers;
import calculator.model.StringNumbers;
import java.util.List;

public class Calculate {

    public static Integer calculateUserInputSum(String userInput) {
        return calculateSplitUserInputSum(calculateSplitUserInput(userInput));
    }

    public static List<String> calculateSplitUserInput(String userInput) {
        return new StringNumbers(userInput).getSplitUserInput();
    }

    public static Integer calculateSplitUserInputSum(List<String> userInput) {
        return new Numbers(userInput).calculateNumbersSum();
    }
}
