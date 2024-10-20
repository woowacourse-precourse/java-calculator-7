package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicCalculator implements Calculator {
    private final Separator separator;
    private final Numbers numbers;

    public BasicCalculator(String input) {
        this.separator = new Separator(input);
        this.numbers = new Numbers(input);
    }

    public int calculate(String operation) {
        return switch (operation) {
            case "add" -> add();
            case "sub" -> sub();
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }

    private int add() {
        return Arrays.stream(splitAndParseNumbers()).sum();
    }

    private int sub() {
        int[] nums = splitAndParseNumbers();
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result -= nums[i];
        }
        return result;
    }

    private int[] splitAndParseNumbers() {
        String[] nums = numbers.getNumbers().split(separator.makeSeparatorsForSplit());
        List<String> numberList = new ArrayList<>(Arrays.asList(nums));
        numberList.removeIf(String::isBlank);

        return numberList.stream()
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
