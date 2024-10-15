package calculator.domain;

import calculator.domain.exception.CalculatorException;
import calculator.domain.exception.ErrorMessage;
import java.util.List;

public class Calculator {
    //계산기가 다루는 수가 정수라 가정
    private final List<Integer> numbers;

    private Calculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Calculator of(List<Integer> numbers) {
        validate(numbers);
        return new Calculator(numbers);
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number <= 0)) {
            throw CalculatorException.from(ErrorMessage.INVALID_RANGE_ERROR);
        }
    }

    public int calculateSum() {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
