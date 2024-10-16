package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Calculator {
    public static int performAddition(String input) {
        List<String> numbers = Parser.splitInput(input);

        if (Objects.equals(input, "")) {
            return 0;
        }

        if (!isValidNumberString(numbers)) {
            throw new IllegalArgumentException();
        }

        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();

    }

    private static boolean isValidNumberString(List<String> numbers) {
        return numbers.stream().allMatch(num -> num.matches("\\d+"));
    }

}
