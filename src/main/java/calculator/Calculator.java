package calculator;

import java.util.List;

public class Calculator {

    private static final int RESULT_WHEN_EMPTY = 0;

    private Calculator() {
    }

    public static int sum(List<Integer> numbers) {
        numbers.forEach(Calculator::validate);

        return numbers.stream()
                .reduce(Integer::sum)
                .orElse(RESULT_WHEN_EMPTY);
    }

    private static void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("숫자는 양수이어야 합니다. number : " + number);
        }
    }
}
