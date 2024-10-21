package calculator;

import java.util.List;

public class Calculator {

    private Calculator() {
    }

    public static int sum(List<Integer> numbers) {
        numbers.forEach(Calculator::validate);

        return numbers.stream()
                .reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("숫자가 존재하지 않습니다."));
    }

    private static void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("숫자는 양수이어야 합니다. number : " + number);
        }
    }
}
