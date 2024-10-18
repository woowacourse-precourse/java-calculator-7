package calculator;

import java.util.Arrays;
import java.util.List;

public class NumberConverter {

    public List<Integer> convertStringToNumber(final String[] splitedByRegex) {
        try {
            return Arrays.stream(splitedByRegex)
                    .filter(str -> str.length() > 0)
                    .map(Integer::parseInt)
                    .map(this::getPositiveNumber)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 범위를 벗어난 수 또는 구분자를 제외한 문자열을 입력할 수 없습니다.");
        }
    }

    private int getPositiveNumber(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닙니다.");
        }

        return number;
    }

}
