package calculator.domain;

import java.util.List;

public class Calculator {
    public static int performAddition(String input) {
        List<String> numbers = Parser.splitInput(input);

        if (!isValidNumberString(numbers)) {
            throw new IllegalArgumentException("숫자와 구분자 외의 문자가 포함되어 있습니다.");
        }

        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isValidNumberString(List<String> numbers) {
        return numbers.stream().allMatch(num -> num.matches("\\d+"));
    }
}
