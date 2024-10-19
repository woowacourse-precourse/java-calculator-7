package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Calculator {

    // split 된 문자열 덧셈 연산 수행
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

    // 구분자로 split 된 문자열의 유효성 확인
    private static boolean isValidNumberString(List<String> numbers) {
        return numbers.stream().allMatch(num -> num.matches("\\d+"));
    }

}
