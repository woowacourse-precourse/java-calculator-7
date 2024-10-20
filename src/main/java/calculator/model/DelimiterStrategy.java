package calculator.model;


import java.util.Arrays;

public interface DelimiterStrategy {

    String[] getStringNumbersArray(String input);

    default String[] checkDuplicatedDelimiters(String[] numbers) {
        if (Arrays.asList(numbers).contains("")) {
            throw new IllegalArgumentException("빈 숫자가 발견되었습니다. 연속된 구분자가 있을 수 있습니다.");
        }
        return numbers;

    }
}