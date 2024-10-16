package calculator.domain;

import java.util.List;

public class Calculator {
    public static int performAddition(String input) {
        List<String> numbers = Parser.splitInput(input);

        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isValidNumberString(List<String> numbers) {
        return numbers.stream().allMatch(num -> num.matches("\\d+"));
    }
}
