package calculator.model;

import java.util.List;

// 문자열 배열의 숫자를 합산하는 계산기
public class StringCalculator {

    public int sumNumbers(List<String> numbers) {
        return calculateSum(numbers);
    }

    private int calculateSum(List<String> numbers) {
        return numbers.stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}