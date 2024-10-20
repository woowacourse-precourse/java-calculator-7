package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Expression {
    private final List<Integer> numbers;
    private final int result;

    public Expression(final String[] input) {
        validate();
        this.numbers = convertToIntegers(input);
        this.result = calculate();
    }

    //TODO 검증 과정 추가
    private void validate() {
    }

    private List<Integer> convertToIntegers(final String[] strings) {
        return Arrays.stream(strings)
                .map(s -> Integer.parseInt(s.trim()))
                .toList();
    }

    private int calculate() {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public int getResult() {
        return result;
    }
}
